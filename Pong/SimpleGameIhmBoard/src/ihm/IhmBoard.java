package ihm;

import ctrl.Ctrl;

/**
 * Infrastructure de base et très simple mettant à disposition une ihm graphique fonctionnelle pour implémenter des
 * jeux.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 14 sept. 2017
 * @version 0.1
 */
public class IhmBoard {

    public IhmBoard() {
        this.refCtrl = null;
        this.innerIhm = new InnerIhm();
    }

    public void ihmStart() {
        innerIhm.ihmStart();
    }

    public void ihmStop() {
        innerIhm.ihmStop();
    }

    public void setScore( int score ) {
        innerIhm.setScore( score );
    }

    public void setBestScore( int bestScore ) {
        innerIhm.setBestScore( bestScore );
    }

    public void setTimeTitle( String title ) {
        innerIhm.setTimeTitle( title );
    }

    public void setTimeValue( int value ) {
        innerIhm.setTimeValue( value );
    }

    public void setBoardDimensions( int numberOfXCells, int numberOfYCells ) {
        innerIhm.setBoardDimensions( numberOfXCells, numberOfYCells );
    }

    public void setBoardDimensions( int numberOfXCells, int numberOfYCells, int cellPixels ) {
        innerIhm.setBoardDimensions( numberOfXCells, numberOfYCells, cellPixels );
    }

    public void clearBoardContent() {
        innerIhm.clearBoardContent();
    }

    public void clearBoardContent( CellContent newContent ) {
        innerIhm.clearBoardContent( newContent );
    }

    public void setBoardContent( int x, int y, CellContent newContent ) {
        innerIhm.setBoardContent( x, y, newContent );
    }

    public CellContent getBoardContent( int x, int y ) {
        return innerIhm.getBoardContent( x, y );
    }

    public void messageInformation( String message ) {
        innerIhm.messageInformation( message );
    }

    public void messageErreur( String message ) {
        innerIhm.messageErreur( message );
    }

    public boolean messageQuestion( String question ) {
        return innerIhm.messageQuestion( question );
    }

    public void dormir( int dureeMilliSecs ) {
        try {
            Thread.sleep( dureeMilliSecs );
        }
        catch ( InterruptedException ex ) {
        }
    }

    public Ctrl getRefCtrl() {
        return refCtrl;
    }

    public void setRefCtrl( Ctrl refCtrl ) {
        this.refCtrl = refCtrl;
    }

    private Ctrl refCtrl;
    private final InnerIhm innerIhm;

    // <editor-fold defaultstate="collapsed" desc="Ihm => NE PAS TOUCHER !!!">
    private class InnerIhm extends javax.swing.JFrame {

        private final static boolean USE_INVOKE_LATER = false;
        private final static int PADDING = 16;

        private final BoardPanel jBoardPanel;
        private final javax.swing.JLabel jLabelScoreValue;
        private final javax.swing.JLabel jLabelBestScoreValue;
        private final javax.swing.JProgressBar jProgressBarTime;
        private final javax.swing.JLabel jLabelTime;

        public InnerIhm() {

            jBoardPanel = new BoardPanel();

            setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE );
            setTitle( "Pong Mathéo Esteban" );

            setResizable( false );
            java.awt.BorderLayout mainFrameLayout = new java.awt.BorderLayout();
            setLayout( mainFrameLayout );
            add( jBoardPanel, java.awt.BorderLayout.CENTER );

            java.awt.GridBagLayout gridbagForScorePanel = new java.awt.GridBagLayout();
            java.awt.GridBagConstraints c = new java.awt.GridBagConstraints();
            c.fill = java.awt.GridBagConstraints.BOTH;
            c.gridwidth = java.awt.GridBagConstraints.REMAINDER;

            javax.swing.JLabel jLabelScore = new javax.swing.JLabel( "Score", javax.swing.JLabel.CENTER );
            jLabelScoreValue = new javax.swing.JLabel( "00000", javax.swing.JLabel.CENTER );
            javax.swing.JLabel jLabelBestScore = new javax.swing.JLabel( "Best", javax.swing.JLabel.CENTER );
            jLabelBestScoreValue = new javax.swing.JLabel( "00000", javax.swing.JLabel.CENTER );
            jLabelTime = new javax.swing.JLabel( "Time", javax.swing.JLabel.CENTER );
            jProgressBarTime = new javax.swing.JProgressBar( 0, 100 );
            javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
            javax.swing.JSeparator jSeparator2 = new javax.swing.JSeparator();
            javax.swing.JButton jButtonQuit = new javax.swing.JButton( "Quitter" );
            javax.swing.JLabel jLabelLogo = new javax.swing.JLabel( new javax.swing.ImageIcon( getClass().getResource( "/ihm/resources/Logo_EMFInfo_transp.png" ) ), javax.swing.JLabel.CENTER );
            String currentYear = "" + ( ( new java.util.Date() ).getYear() + 1900 );
            javax.swing.JLabel jLabelCopyright = new javax.swing.JLabel( "<html>Simple Game UI Infrastructure<div align=\"right\"><font size=\"2\" color=\"gray\" face=\"Arial\">Written by Paul FRIEDLI<br>Copyright © " + currentYear + "</font></div></html>", javax.swing.JLabel.CENTER );
            javax.swing.JLabel jLabelEmpty = new javax.swing.JLabel( " ", javax.swing.JLabel.CENTER );
            jButtonQuit.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/ihm/resources/quit-32.png" ) ) );
            java.awt.Font scoreTitlesFont = new java.awt.Font( "Arial", 1, 24 );
            java.awt.Font scoreValuesFont = new java.awt.Font( "Consolas", 0, 32 );
            java.awt.Color scoreColor = new java.awt.Color( 128, 0, 0 );
            java.awt.Color scoreBestColor = new java.awt.Color( 0, 128, 0 );
            jLabelScoreValue.setFont( scoreValuesFont );
            jLabelBestScoreValue.setFont( scoreValuesFont );
            jLabelScoreValue.setForeground( scoreColor );
            jLabelBestScoreValue.setForeground( scoreBestColor );
            jLabelScore.setFont( scoreTitlesFont );
            jLabelBestScore.setFont( scoreTitlesFont );
            jLabelTime.setFont( scoreTitlesFont );
            jButtonQuit.setFont( new java.awt.Font( "Arial", 0, 24 ) );

            jLabelCopyright.setFont( new java.awt.Font( "Calibri", 0, 13 ) );

            jProgressBarTime.setFont( new java.awt.Font( "Arial", 0, 13 ) );
            jProgressBarTime.setValue( 0 );

            javax.swing.JPanel scorePanel = new javax.swing.JPanel();
            scorePanel.setLayout( gridbagForScorePanel );
            gridbagForScorePanel.setConstraints( jLabelScore, c );
            gridbagForScorePanel.setConstraints( jLabelScoreValue, c );
            gridbagForScorePanel.setConstraints( jSeparator1, c );
            gridbagForScorePanel.setConstraints( jLabelBestScore, c );
            gridbagForScorePanel.setConstraints( jLabelBestScoreValue, c );
            gridbagForScorePanel.setConstraints( jSeparator2, c );
            gridbagForScorePanel.setConstraints( jLabelTime, c );
            gridbagForScorePanel.setConstraints( jProgressBarTime, c );

            scorePanel.add( jLabelScore );
            scorePanel.add( jLabelScoreValue );
            scorePanel.add( jSeparator1 );
            scorePanel.add( jLabelBestScore );
            scorePanel.add( jLabelBestScoreValue );
            scorePanel.add( jSeparator2 );
            scorePanel.add( jLabelTime );
            scorePanel.add( jProgressBarTime );

            java.awt.BorderLayout layoutForButtonPanel = new java.awt.BorderLayout();
            javax.swing.JPanel outerPanel = new javax.swing.JPanel();
            outerPanel.setLayout( layoutForButtonPanel );
            outerPanel.add( jButtonQuit, java.awt.BorderLayout.NORTH );
            outerPanel.add( jLabelEmpty, java.awt.BorderLayout.CENTER );
            outerPanel.add( jLabelCopyright, java.awt.BorderLayout.SOUTH );

            javax.swing.JPanel rightPanel = new javax.swing.JPanel();
            rightPanel.setLayout( new java.awt.BorderLayout() );
            rightPanel.add( outerPanel, java.awt.BorderLayout.NORTH );
            rightPanel.add( jLabelLogo, java.awt.BorderLayout.CENTER );
            rightPanel.add( scorePanel, java.awt.BorderLayout.SOUTH );

            add( rightPanel, java.awt.BorderLayout.EAST );

            rightPanel.setBorder( new javax.swing.border.EmptyBorder( PADDING, PADDING, PADDING, PADDING ) );
            scorePanel.setBorder( javax.swing.BorderFactory.createCompoundBorder( new javax.swing.border.BevelBorder( javax.swing.border.BevelBorder.LOWERED ), new javax.swing.border.EmptyBorder( 10, 10, 10, 10 ) ) );

            jButtonQuit.addActionListener( new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed( java.awt.event.ActionEvent e ) {
                    refCtrl.actionQuitter();
                }
            } );

            pack();
            setLocationRelativeTo( null );  //Screen center
        }

        public void ihmStart() {
            // Afficher l'ihm
            setVisible( true );
        }

        public void ihmStop() {
            // Arrêter ce qui doit être arrêté côté InnerIhm (timer, threads, ..)
            // Fermer l'InnerIhm
            dispose();
        }

        public void setScore( int score ) {
            if ( USE_INVOKE_LATER ) {
                javax.swing.SwingUtilities.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        jLabelScoreValue.setText( "" + score );
                    }
                } );
            } else {
                jLabelScoreValue.setText( "" + score );
            }
        }

        public void setBestScore( int bestScore ) {
            if ( USE_INVOKE_LATER ) {
                javax.swing.SwingUtilities.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        jLabelBestScoreValue.setText( "" + bestScore );
                    }
                } );
            } else {
                jLabelBestScoreValue.setText( "" + bestScore );
            }
        }

        public void setTimeTitle( String title ) {
            if ( USE_INVOKE_LATER ) {
                javax.swing.SwingUtilities.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        jLabelTime.setText( title );
                    }
                } );
            } else {
                jLabelTime.setText( title );
            }
        }

        public void setTimeValue( int value ) {
            if ( ( value < 0 ) || ( value > 100 ) ) {
                throw new RuntimeException( "Valeur incorrecte pour le temps (reçu " + value + " et doit toujours être entre 0 et 100 )" );
            } else {
                if ( USE_INVOKE_LATER ) {
                    javax.swing.SwingUtilities.invokeLater( new Runnable() {
                        @Override
                        public void run() {
                            jProgressBarTime.setValue( value );
                        }
                    } );
                } else {
                    jProgressBarTime.setValue( value );
                }
            }
        }

        public void setBoardDimensions( int numberOfXCells, int numberOfYCells ) {
            if ( USE_INVOKE_LATER ) {
                javax.swing.SwingUtilities.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        jBoardPanel.setBoardDimensions( numberOfXCells, numberOfYCells );
                        pack();
                        setLocationRelativeTo( null );  //Screen center
                        repaint();
                    }
                } );
            } else {
                jBoardPanel.setBoardDimensions( numberOfXCells, numberOfYCells );
                pack();
                setLocationRelativeTo( null );  //Screen center
                repaint();
            }
        }

        public void setBoardDimensions( int numberOfXCells, int numberOfYCells, int cellPixels ) {
            if ( USE_INVOKE_LATER ) {
                javax.swing.SwingUtilities.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        jBoardPanel.setBoardDimensions( numberOfXCells, numberOfYCells, cellPixels );
                        pack();
                        setLocationRelativeTo( null );  //Screen center
                        repaint();
                    }
                } );
            } else {
                jBoardPanel.setBoardDimensions( numberOfXCells, numberOfYCells, cellPixels );
                pack();
                setLocationRelativeTo( null );  //Screen center
                repaint();
            }
        }

        public void clearBoardContent() {
            if ( USE_INVOKE_LATER ) {
                javax.swing.SwingUtilities.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        jBoardPanel.clearBoardContent();
                    }
                } );
            } else {
                jBoardPanel.clearBoardContent();
            }
        }

        public void clearBoardContent( CellContent newContent ) {
            if ( USE_INVOKE_LATER ) {
                javax.swing.SwingUtilities.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        jBoardPanel.clearBoardContent( newContent );
                    }
                } );
            } else {
                jBoardPanel.clearBoardContent( newContent );
            }
        }

        public void setBoardContent( int x, int y, CellContent newContent ) {
            if ( USE_INVOKE_LATER ) {
                javax.swing.SwingUtilities.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        jBoardPanel.setBoardContent( x, y, newContent );
                    }
                } );
            } else {
                jBoardPanel.setBoardContent( x, y, newContent );
            }
        }

        public CellContent getBoardContent( int x, int y ) {
            return jBoardPanel.getBoardContent( x, y );
        }

        public void messageInformation( String message ) {
            javax.swing.ImageIcon informationIcon = new javax.swing.ImageIcon( getClass().getResource( "resources/msgboxicon-info-48.png" ) );
            javax.swing.JOptionPane.showMessageDialog( this, message, "Information", javax.swing.JOptionPane.INFORMATION_MESSAGE, informationIcon );
        }

        public void messageErreur( String message ) {
            javax.swing.ImageIcon warningIcon = new javax.swing.ImageIcon( getClass().getResource( "resources/msgboxicon-error-48.png" ) );
            javax.swing.JOptionPane.showMessageDialog( this, message, "Information", javax.swing.JOptionPane.INFORMATION_MESSAGE, warningIcon );
        }

        public boolean messageQuestion( String question ) {
            javax.swing.ImageIcon questionIcon = new javax.swing.ImageIcon( getClass().getResource( "resources/msgboxicon-question-48.png" ) );
            return ( javax.swing.JOptionPane.showConfirmDialog( getRootPane(), question, "Question", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, questionIcon ) == javax.swing.JOptionPane.YES_OPTION );
        }

        // <editor-fold defaultstate="collapsed" desc="Sous-classe pour le board => ne pas toucher !">
        protected class BoardPanel extends javax.swing.JPanel {

            public final static int DEFAULT_X_CELLS = 10;
            public final static int DEFAULT_Y_CELLS = 10;
            public final static int DEFAULT_CELL_SIZE = 36;
            public final static int MAX_NUMBER_OF_CELLS = 256;

            // Le contenu des cellules du jeu
            private CellContent[][] boardCellsContent;
            private int cellPixelSize;
            private int cellAmountX;
            private int cellAmountY;

            public BoardPanel() {
                setBoardDimensions( DEFAULT_X_CELLS, DEFAULT_Y_CELLS, DEFAULT_CELL_SIZE );
            }

            public void setBoardDimensions( int numberOfXCells, int numberOfYCells ) {
                setBoardDimensions( numberOfXCells, numberOfYCells, DEFAULT_CELL_SIZE );
            }

            public void setBoardDimensions( int numberOfXCells, int numberOfYCells, int cellPixels ) {
                if ( ( numberOfXCells < 0 ) || ( numberOfXCells > MAX_NUMBER_OF_CELLS ) ) {
                    throw new RuntimeException( "Surface de jeu incorrecte (reçu " + numberOfXCells + " cellules et doit être entre 0 et " + MAX_NUMBER_OF_CELLS + " )" );
                } else if ( ( numberOfYCells < 0 ) || ( numberOfYCells > MAX_NUMBER_OF_CELLS ) ) {
                    throw new RuntimeException( "Surface de jeu incorrecte (reçu " + numberOfYCells + " cellules et doit être entre 0 et " + MAX_NUMBER_OF_CELLS + " )" );
                } else {
                    cellPixelSize = cellPixels;
                    cellAmountX = numberOfXCells;
                    cellAmountY = numberOfYCells;
                    boardCellsContent = new CellContent[ cellAmountY ][ cellAmountX ];
                    clearBoardContent();
                    java.awt.Dimension dimensions = new java.awt.Dimension( cellAmountX * cellPixelSize, cellAmountY * cellPixelSize );
                    setPreferredSize( dimensions );
                    setMinimumSize( dimensions );
                    setMaximumSize( dimensions );
                    setBackground( java.awt.Color.BLACK );
                    repaint();
                }
            }

            public void clearBoardContent() {
                clearBoardContent( CellContent.WHITE );
            }

            public void clearBoardContent( CellContent newContent ) {
                for ( int y = 0; y < boardCellsContent.length; y++ ) {
                    for ( int x = 0; x < boardCellsContent[ 0 ].length; x++ ) {
                        boardCellsContent[ y ][ x ] = newContent;
                    }
                }
                repaint();
            }

            public void setBoardContent( int x, int y, CellContent newContent ) {
                if ( ( x < 0 ) || ( x >= cellAmountX ) ) {
                    throw new RuntimeException( "Valeur de x hors limites (reçu " + x + " et doit être entre " + 0 + " et " + ( cellAmountX - 1 ) + " )" );
                } else if ( ( y < 0 ) || ( y >= cellAmountY ) ) {
                    throw new RuntimeException( "Valeur de y hors limites (reçu " + y + " et doit être entre " + 0 + " et " + ( cellAmountY - 1 ) + " )" );
                } else if ( ( newContent == null ) ) {
                    throw new RuntimeException( "Le contenu de la cellule (" + x + ", " + y + ") ne peut pas recevoir une telle valeur (" + newContent + ")" );
                } else {
                    boardCellsContent[ y ][ x ] = newContent;
                    repaint();
                }
            }

            public CellContent getBoardContent( int x, int y ) {
                if ( ( x < 0 ) || ( x >= cellAmountX ) ) {
                    throw new RuntimeException( "Valeur de x hors limites (reçu " + x + " et doit être entre " + 0 + " et " + ( cellAmountX - 1 ) + " )" );
                } else if ( ( y < 0 ) || ( y >= cellAmountY ) ) {
                    throw new RuntimeException( "Valeur de y hors limites (reçu " + y + " et doit être entre " + 0 + " et " + ( cellAmountY - 1 ) + " )" );
                }

                return boardCellsContent[ y ][ x ];
            }

            @Override
            public void paintComponent( java.awt.Graphics g ) {
                // On demande au parent de se redessiner 
                super.paintComponent( g );
                // Cellule par cellule, les dessiner selon leur états
                for ( int y = 0; y < boardCellsContent.length; y++ ) {
                    for ( int x = 0; x < boardCellsContent[ 0 ].length; x++ ) {
                        CellContent content = boardCellsContent[ y ][ x ];
                        java.awt.Color color;
                        switch ( content ) {
                            case BLACK:
                                color = java.awt.Color.BLACK;
                                break;
                            case BLUE:
                                color = java.awt.Color.BLUE;
                                break;
                            case PINK:
                                color = java.awt.Color.PINK;
                                break;
                            case DARKGRAY:
                                color = java.awt.Color.DARK_GRAY;
                                break;
                            case GRAY:
                                color = java.awt.Color.GRAY;
                                break;
                            case LIGHTGRAY:
                                color = java.awt.Color.LIGHT_GRAY;
                                break;
                            case WHITE:
                            default:
                                color = java.awt.Color.WHITE;
                                break;
                        }
                        g.setColor( color );
                        g.fillRect( x * cellPixelSize, y * cellPixelSize, cellPixelSize - 1, cellPixelSize - 1 );
                    }
                }
            }
        }
        // </editor-fold>  
    }
    // </editor-fold>  
}
