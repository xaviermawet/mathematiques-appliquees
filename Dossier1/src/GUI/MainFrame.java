package GUI;

import java.awt.GridBagConstraints;

/**
 *
 * @author Nakim
 */
public class MainFrame extends javax.swing.JFrame
{
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public MainFrame()
    {
        // GUI Configuration
        this.initComponents();

        // Plots creation
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Maximum width and height
        gbc.weightx = 1;
        gbc.weighty = 1;


        this.plotSignalSerieFourier = new SignalPanel("Signal de départ et série de Fourier", null, null);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 2;
        this.panelPlots.add(this.plotSignalSerieFourier, gbc);

        this.plotSpectreSerieFourier = new SignalPanel("Spectre de la série de Fourier", null, null);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        this.panelPlots.add(this.plotSpectreSerieFourier, gbc);

        this.plotRealPartTFSerieF = new SignalPanel("Partie réelle de la transformée de Fourier de la série de Fourier", null, null);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        this.panelPlots.add(this.plotRealPartTFSerieF, gbc);

        this.plotImaginaryPartTFSerieF = new SignalPanel("Partie imaginaire de la transformée de Fourier de la série de Fourier", null, null);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        this.panelPlots.add(this.plotImaginaryPartTFSerieF, gbc);

        this.plotPhaseTFSerieF = new SignalPanel("Phase de la transformée de Fourier de la série de Fourier", null, null);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        this.panelPlots.add(this.plotPhaseTFSerieF, gbc);

        // Resize window to fit the preferred sizes and layouts
        this.pack();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        splitPaneMainFrame = new javax.swing.JSplitPane();
        panelOptions = new javax.swing.JPanel();
        panelDiscretiseur = new javax.swing.JPanel();
        labelSamples = new javax.swing.JLabel();
        labelOrigine = new javax.swing.JLabel();
        labelDuree = new javax.swing.JLabel();
        spinnerSamplesDisc = new javax.swing.JSpinner();
        spinnerOrigineDisc = new javax.swing.JSpinner();
        spinnerDureeDisc = new javax.swing.JSpinner();
        panelPlots = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mathématiques Appliquées - Dossier 1");

        splitPaneMainFrame.setOneTouchExpandable(true);

        panelOptions.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panelOptions.setLayout(new java.awt.GridBagLayout());

        panelDiscretiseur.setBorder(javax.swing.BorderFactory.createTitledBorder("Paramètres du discretiseur"));
        java.awt.GridBagLayout panelDiscretiseurLayout = new java.awt.GridBagLayout();
        panelDiscretiseurLayout.columnWidths = new int[] {0, 5, 0};
        panelDiscretiseurLayout.rowHeights = new int[] {0, 3, 0, 3, 0};
        panelDiscretiseur.setLayout(panelDiscretiseurLayout);

        labelSamples.setText("Samples :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelDiscretiseur.add(labelSamples, gridBagConstraints);

        labelOrigine.setText("Origine :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelDiscretiseur.add(labelOrigine, gridBagConstraints);

        labelDuree.setText("Durée :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelDiscretiseur.add(labelDuree, gridBagConstraints);

        spinnerSamplesDisc.setModel(new javax.swing.SpinnerNumberModel(4096, 64, 4096, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelDiscretiseur.add(spinnerSamplesDisc, gridBagConstraints);

        spinnerOrigineDisc.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(0.1d)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelDiscretiseur.add(spinnerOrigineDisc, gridBagConstraints);

        spinnerDureeDisc.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(0.0d), null, Double.valueOf(0.1d)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelDiscretiseur.add(spinnerDureeDisc, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelOptions.add(panelDiscretiseur, gridBagConstraints);

        splitPaneMainFrame.setLeftComponent(panelOptions);

        panelPlots.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panelPlots.setLayout(new java.awt.GridBagLayout());
        splitPaneMainFrame.setRightComponent(panelPlots);

        getContentPane().add(splitPaneMainFrame, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Main">
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new MainFrame().setVisible(true);
        });
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Variables declaration">

    private final SignalPanel plotSignalSerieFourier;
    private final SignalPanel plotSpectreSerieFourier;
    private final SignalPanel plotRealPartTFSerieF;
    private final SignalPanel plotImaginaryPartTFSerieF;
    private final SignalPanel plotPhaseTFSerieF;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDuree;
    private javax.swing.JLabel labelOrigine;
    private javax.swing.JLabel labelSamples;
    private javax.swing.JPanel panelDiscretiseur;
    private javax.swing.JPanel panelOptions;
    private javax.swing.JPanel panelPlots;
    private javax.swing.JSpinner spinnerDureeDisc;
    private javax.swing.JSpinner spinnerOrigineDisc;
    private javax.swing.JSpinner spinnerSamplesDisc;
    private javax.swing.JSplitPane splitPaneMainFrame;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
