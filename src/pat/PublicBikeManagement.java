package pat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PublicBikeManagement {
    static int dist[]; // the distance to the start
    static int bikes[];// the number of bikes in each state
    static boolean visited[];//
    static ArrayList edgeTo[];//the preNode of every node
    static int map[][];// store the edge

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cMax = sc.nextInt(), staNum = sc.nextInt(), proSta = sc.nextInt(), roadNum = sc.nextInt();
        bikes = new int[staNum + 1];
        dist = new int[staNum + 1];
        visited = new boolean[staNum + 1];
        edgeTo = new ArrayList[staNum + 1];
        for (int i = 1; i <= staNum; i++) {
            bikes[i] = sc.nextInt();
        }
        for (int i = 0; i <= staNum; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        map = new int[staNum + 1][staNum + 1];
        for (int i = 0; i <= staNum; i++) {
            for (int j = 0; j <= staNum; j++) {
                if (i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = Integer.MAX_VALUE;

            }
        }
        for (int i = 0; i < roadNum; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = map[b][a] = sc.nextInt();
        }
        dijkstra(0, proSta, cMax, staNum);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findPath(0, proSta, path, list);
        // 现在list中存放着左右路径，对所有路径的所需车辆数进行计算
        NeedBike[] needBike = new NeedBike[list.size()];
        for (int i = 0; i < list.size(); i++) {
            needBike[i] = calculateBike(list.get(i), cMax);
        }
        Arrays.sort(needBike, new Comparator<NeedBike>() {

            @Override
            public int compare(NeedBike o1, NeedBike o2) {
                if (o1.needBike != o2.needBike)
                    return o1.needBike - o2.needBike;
                else
                    return o1.backBike - o2.backBike;
            }
        });
        // 输出结果
        NeedBike res = needBike[0];
        System.out.print(res.needBike);

        ArrayList<Integer> road = res.road;
        System.out.print(" " + road.get(road.size() - 1));
        for (int i = road.size() - 2; i >= 0; i--) {
            System.out.print("->" + road.get(i));
        }
        System.out.print(" " + res.backBike);

    }


    private static void dijkstra(int res, int dest, int cMax, int staNum) {
        dist[res] = 0;
        int curSta = res;
        while (true) {
            if (curSta == -1)
                break;
            visited[curSta] = true;
            for (int i = 0; i <= staNum; i++) {
                // curSta加入已遍历集合后，更新所有站点的路径
                //// (map[curNode][i] + dist[curNode] < dist[i])会溢出
                if (!visited[i] && map[curSta][i] <= dist[i] - dist[curSta]) {
                    if (edgeTo[i] == null)
                        edgeTo[i] = new ArrayList<Integer>();
                    if (map[curSta][i] + dist[curSta] < dist[i]) {
                        dist[i] = map[curSta][i] + dist[curSta];
                        edgeTo[i].clear();
                        edgeTo[i].add(curSta);
                    } else
                        edgeTo[i].add(curSta);
                }
            }
            int min = Integer.MAX_VALUE, index = -1;
            for (int i = 0; i <= staNum; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    index = i;
                }
            }
            curSta = index;
        }
    }

    private static void findPath(int res, int proSta, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> list) {
        if (res == proSta) {
            path.add(res);
            list.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        ArrayList<Integer> pre = edgeTo[proSta];
        for (int a : pre) {
            path.add(proSta);
            findPath(res, a, path, list);
            path.remove(path.size() - 1);
        }


    }

    private static NeedBike calculateBike(ArrayList<Integer> array, int cMax) {
        NeedBike res = new NeedBike();
        int needBike = 0, curBike = 0;
        int backBike = 0;
        // 因为array.get(array.size()-1)是主站，不需要自行车
        for (int i = array.size() - 2; i >= 0; i--) {
            // 车辆不够，需要从主站中获取
            if (bikes[array.get(i)] + curBike < cMax / 2) {
                needBike += cMax / 2 - bikes[array.get(i)] - curBike;
                curBike = 0;
            } else {// 车辆足够
                curBike = bikes[array.get(i)] + curBike - cMax / 2;
            }
            if (i == 0)
                backBike = curBike;
        }
        res.needBike = needBike;
        res.backBike = backBike;
        res.road = array;
        return res;
    }

 private static class NeedBike {
        int needBike;
        int backBike;
        ArrayList<Integer> road;

        @Override
        public String toString() {
            return "NeedBike [needBike=" + needBike + ", backBike=" + backBike + "]";
        }


    }
}
