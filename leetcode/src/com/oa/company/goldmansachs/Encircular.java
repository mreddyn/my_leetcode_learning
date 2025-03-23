package com.oa.company.goldmansachs;

public class Encircular {
    public String[] doesCircleExist(String[] commands) {
        if (commands == null || commands.length == 0) {
            return new String[0];
        }

        int n = commands.length;
        var res = new String[n];

        for (int i = 0; i < n; i++) {
            res[i] = isCircle(commands[i]) ? "YES" : "NO";
        }

        return res;
    }

    private boolean isCircle(String command) {
        int x = 0;
        int y = 0;
        int direction = 0; // 0: north, 1: east, 2: south, 3: west

        for (char c : command.toCharArray()) {
            if (c == 'G') {
                switch (direction) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x++;
                        break;
                    case 2:
                        y--;
                        break;
                    default:
                        x--;
                        break;
                }
            } else if (c == 'L') {
                direction = (direction + 3) % 4;
            } else {
                direction = (direction + 1) % 4;
            }
        }

        return x == 0 && y == 0 || direction != 0;
    }

    public static void main(String[] args) {
        Encircular obj = new Encircular();
        String[] commands = { "G", "L", "RGRG" };
        var res = obj.doesCircleExist(commands);
        for (var s : res) {
            System.out.println(s);
        }
    }
}
