package com.company;

import javax.swing.*;
import java.awt.*;

/**
 *Creates and displays a graphical representation of the output matrix
 */
public class Display {

    /**
     * Creates and displays the output
     * @param board a char matrix that
     */
    public static void  disp(char[][] board) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // The colored square class
                class ColoredSquare {
                    private Color color;
                    private Rectangle rect;
                    private int width;
                    private int height;
                    public ColoredSquare(Color c, int x, int y) {
                        color = c;
                        width = 64;
                        height = 64;
                        rect = new Rectangle(x,y,width,height);
                    }
                    public void draw(Graphics g) {
                        g.setColor(color);
                        g.fillRect(rect.x, rect.y, width, height);
                    }
                } // End ColoredSquare class
                JPanel panel = new JPanel() {
                    ColoredSquare[][] squares;
                    int squareSize = 64;
                    {
                        squares = new ColoredSquare[board[0].length][board.length];

                        setPreferredSize(new Dimension(board[0].length* 64, board.length * 64));
                        this.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
                        populateSquares();
                    }

                    private void populateSquares() {

                        for (int col = 0; col < squares.length; col++) { //each column.
                            for (int row = 0; row < squares[0].length; row++) { //each row.
                                if (board[row][col] == 'u') {
                                    squares[col][row] = new ColoredSquare(new Color(0, 0, 0)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'f') {
                                    squares[col][row] = new ColoredSquare(new Color(255, 255, 255)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 't') {
                                    squares[col][row] = new ColoredSquare(new Color(255, 0, 0)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'w') {
                                    squares[col][row] = new ColoredSquare(new Color(0, 255, 0)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'p') {
                                    squares[col][row] = new ColoredSquare(new Color(0, 0, 255)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'x') {
                                    squares[col][row] = new ColoredSquare(new Color(255, 255, 0)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'v') {
                                    squares[col][row] = new ColoredSquare(new Color(0, 255, 255)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'y') {
                                    squares[col][row] = new ColoredSquare(new Color(0, 0, 128)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'i') {
                                    squares[col][row] = new ColoredSquare(new Color(0, 128, 128)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'z') {
                                    squares[col][row] = new ColoredSquare(new Color(128, 0, 128)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'l') {
                                    squares[col][row] = new ColoredSquare(new Color(0, 129, 0)
                                            ,col * squareSize, row * squareSize);
                                }
                                if (board[row][col] == 'n') {
                                    squares[col][row] = new ColoredSquare(new Color(128, 0, 0)
                                            ,col * squareSize, row * squareSize);
                                }
                            }
                        }
                    }

                    private void paintSquares(Graphics g) {
                        int width = squares.length;
                        int height = squares[0].length;

                        for(int row = 0; row < width; row++) {
                            for(int col = 0; col < height; col++) {
                                squares[row][col].draw(g);
                            }
                        }
                    }

                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        paintSquares(g);
                    }
                }; // end jpanel

                // The main window
                JFrame frame = new JFrame("Colored squares.");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                frame.setResizable(false);
                frame.pack();
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
                int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
                frame.setLocation(x, y);
                frame.setVisible(true);
            }
        }); // end invokeLater()
    } // end main()
}// end class