package class03;
public class MagicSquare {
    public static void main(String[] args) {
        int n = 5; // Size of the magic square
        int[][] magicSquare = new int[n][n];
        
        // Initialize position for 1
        int num = 1;
        int row = 0;
        int col = n / 2;
        int curr_row;
        int curr_col;
        
        while (num <= n * n) {
            magicSquare[row][col] = num; // Place the number
            
            // Save the current position
            curr_row = row;
            curr_col = col;
            
            // Move to the next position
            row -= 1;
            col += 1;
            
            // Wrap around if row goes out of bounds
            if (row < 0) {
                row = n - 1;
            }
            
            // Wrap around if column goes out of bounds
            if (col == n) {
                col = 0;
            }
            
            // If the cell is already filled, move to the position below the current cell
            if (magicSquare[row][col] != 0) {
                row = curr_row + 1;
                col = curr_col;
                if (row == n) {
                    row = 0;
                }
            }
            
            num++;
        }
        
        // Print the magic square
        System.out.println("The Magic Square for " + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(magicSquare[i][j] + "\t");
            }
            System.out.println();
        }
    }
}