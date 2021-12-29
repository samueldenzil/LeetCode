
public class PatternQuestions {

    public static void main(String[] args) {
        pattern17(4);
    }

    public static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // when one row is printed we have to add a new-line
            System.out.println();
        }
    }

    public static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColInRow = row > n ? (2 * n - row) : row;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern6(int n) {
        for (int row = 0; row < n; row++) {
            for (int space = 0; space < n - row - 1; space++) {
                System.out.print("  ");
            }
            for (int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern7(int n) {
        for (int row = 0; row < n; row++) {

            for (int space = 0; space < row; space++) {
                System.out.print("  ");
            }

            for (int col = 0; col < n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n) {
        for (int row = 0; row < n; row++) {

            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");
            }

            for (int col = 0; col < 2 * row + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern9(int n) {
        for (int row = 0; row < n; row++) {

            for (int space = 0; space < row; space++) {
                System.out.print("  ");
            }

            for (int col = 2 * (n - row) - 1; col > 0; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern10(int n) {
        for (int row = 0; row < n; row++) {

            for (int space = 0; space < n - row; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern11(int n) {
        for (int row = 0; row < n; row++) {

            for (int space = 0; space < row; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col < n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern12(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColInRow = row >= n ? row - n + 1 : n - row;
            int totalSpaceInRow = n - totalColInRow;

            for (int space = 0; space < totalSpaceInRow; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern15(int n) {
        for (int row = 1; row < 2 * n; row++) {
            int totalColInRow = row > n ? 2 * n - row : row;
            int totalSpaceInRow = n - totalColInRow;

            for (int space = 0; space < totalSpaceInRow; space++) {
                System.out.print(" ");
            }

            for (int col = totalColInRow; col >= 1; col--) {
                if (col == totalColInRow) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
            }
            for (int col = 2; col <= totalColInRow; col++) {
                if (col == totalColInRow) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern17(int n) {
        for (int row = 1; row < 2 * n; row++) {

            int totalColInRow = row > n ? 2 * n - row : row;

            for (int space = 0; space < n - totalColInRow; space++) {
                System.out.print("  ");
            }

            for (int col = totalColInRow; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= totalColInRow; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void pattern18(int n) {
        for (int row = 0; row < 2 * n; row++) {

            int totalColInRow = row >= n ? row - n + 1 : n - row;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }

            int totalSpaceInRow = n - totalColInRow;
            for (int space = 0; space < totalSpaceInRow; space++) {
                System.out.print("    ");
            }

            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern19(int n) {
        for (int row = 0; row < 2 * n - 1; row++) {
            int totalColInRow = row >= n ? 2 * n - row - 1 : row + 1;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }

            int totalSpaceInRow = n - totalColInRow;
            for (int space = 0; space < totalSpaceInRow; space++) {
                System.out.print("    ");
            }

            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern24(int n) {
        for (int row = 1; row <= 2 * n; row++) {

            int totalColInRow = row > n ? 2 * n - row + 1 : row;

            for (int col = 1; col <= totalColInRow; col++) {
                if (col == 1 || col == totalColInRow) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            for (int space = 0; space < n - totalColInRow; space++) {
                System.out.print("    ");
            }

            for (int col = 1; col <= totalColInRow; col++) {
                if (col == 1 || col == totalColInRow) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern26(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = n - row + 1; col > 0; col--) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }

    public static void pattern28(int n) {
        for (int row = 0; row < 2 * n - 1; row++) {
            int totalColInRow = row >= n ? (2 * n - row - 1) : row + 1;

            int totalSpaceInRow = n - totalColInRow;
            for (int space = 0; space < totalSpaceInRow; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern30(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

    }

    public static void pattern35(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }

            for (int space = 0; space < n - row; space++) {
                System.out.print("    ");
            }

            for (int col = row; col > 0; col--) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

