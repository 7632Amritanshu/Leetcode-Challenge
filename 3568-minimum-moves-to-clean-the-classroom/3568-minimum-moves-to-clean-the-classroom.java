import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startR = i;
                    startC = j;
                } else if (c == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }
        
        int k = litters.size();
        int fullMask = (1 << k) - 1;
        
        int initialMask = 0;
        for (int idx = 0; idx < k; idx++) {
            if (litters.get(idx)[0] == startR && litters.get(idx)[1] == startC) {
                initialMask |= (1 << idx);
                break;
            }
        }
        
        if (initialMask == fullMask) return 0;
        
        int[][][] maxEnergySeen = new int[m][n][1 << k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergySeen[i][j], -1);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startR, startC, initialMask, energy});
        maxEnergySeen[startR][startC][initialMask] = energy;
        
        int moves = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                
                if (mask == fullMask) return moves;
                if (e == 0) continue;
                
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }
                    
                    char cell = classroom[nr].charAt(nc);
                    int nextE = (cell == 'R') ? energy : e - 1;
                    int nextMask = mask;
                    
                    if (cell == 'L') {
                        for (int idx = 0; idx < k; idx++) {
                            if (litters.get(idx)[0] == nr && litters.get(idx)[1] == nc) {
                                nextMask |= (1 << idx);
                                break;
                            }
                        }
                    }
                    
                    if (nextE > maxEnergySeen[nr][nc][nextMask]) {
                        maxEnergySeen[nr][nc][nextMask] = nextE;
                        q.offer(new int[]{nr, nc, nextMask, nextE});
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}