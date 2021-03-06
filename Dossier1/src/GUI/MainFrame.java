package GUI;

import Fonctions.FonctionA;
import Fonctions.FonctionB;
import Fourier.CarreSerieFourier;
import Fourier.DentsScieSerieFourier;
import Fourier.FonctionASerieFourier;
import Fourier.FonctionBSerieFourier;
import Fourier.FourierSeriesBuilder;
import Fourier.SerieFourier;
import Utils.MessageBoxes;
import java.awt.Color;
import java.awt.GridBagConstraints;
import operations.Fourier;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import signaux.Discretiseur;
import signaux.Signal;
import signaux.SignalPeriodique;

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

        XYItemRenderer renderer;

        this.plotSignalSerieFourier = new SignalPanel("Signal de départ et séries de Fourier (SF)", null, null);
        renderer = this.plotSignalSerieFourier.getChartPanel().getChart().getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.blue);
        renderer.setSeriesPaint(2, Color.yellow);
        renderer.setSeriesPaint(3, Color.cyan);
        renderer.setSeriesPaint(4, Color.magenta);
        renderer.setSeriesPaint(5, Color.green);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 2;
        this.panelPlots.add(this.plotSignalSerieFourier, gbc);

        this.plotSpectreSerieFourier = new SignalPanel("Spectre des séries de Fourier (SF)", null, null);
        renderer = this.plotSpectreSerieFourier.getChartPanel().getChart().getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesPaint(1, Color.yellow);
        renderer.setSeriesPaint(2, Color.cyan);
        renderer.setSeriesPaint(3, Color.magenta);
        renderer.setSeriesPaint(4, Color.green);
        renderer.setSeriesPaint(5, Color.red);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        this.panelPlots.add(this.plotSpectreSerieFourier, gbc);

        this.plotRealPartTFSerieF = new SignalPanel("Partie réelle des TF des Séries de F.", null, null);
        renderer = this.plotRealPartTFSerieF.getChartPanel().getChart().getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesPaint(1, Color.yellow);
        renderer.setSeriesPaint(2, Color.cyan);
        renderer.setSeriesPaint(3, Color.magenta);
        renderer.setSeriesPaint(4, Color.green);
        renderer.setSeriesPaint(5, Color.red);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        this.panelPlots.add(this.plotRealPartTFSerieF, gbc);

        this.plotImaginaryPartTFSerieF = new SignalPanel("Partie imaginaire des TF des séries de F.", null, null);
        renderer = this.plotImaginaryPartTFSerieF.getChartPanel().getChart().getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesPaint(1, Color.yellow);
        renderer.setSeriesPaint(2, Color.cyan);
        renderer.setSeriesPaint(3, Color.magenta);
        renderer.setSeriesPaint(4, Color.green);
        renderer.setSeriesPaint(5, Color.red);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        this.panelPlots.add(this.plotImaginaryPartTFSerieF, gbc);

        this.plotPhaseTFSerieF = new SignalPanel("Phase de la TF de la SF", null, null);
        renderer = this.plotPhaseTFSerieF.getChartPanel().getChart().getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesPaint(1, Color.yellow);
        renderer.setSeriesPaint(2, Color.cyan);
        renderer.setSeriesPaint(3, Color.magenta);
        renderer.setSeriesPaint(4, Color.green);
        renderer.setSeriesPaint(5, Color.red);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        this.panelPlots.add(this.plotPhaseTFSerieF, gbc);

        // Private variables initialization
        this.signal = null;
        this.serieFourier = null;
        this.discretiseur = null;
        this.periode = -1.0;
        this.amplitude = -1.0;
        this.signalType = null;

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
        panelSignals = new javax.swing.JPanel();
        labelChoixSignal = new javax.swing.JLabel();
        comboBoxSignaux = new javax.swing.JComboBox();
        labelPeriode = new javax.swing.JLabel();
        spinnerPeriode = new javax.swing.JSpinner();
        buttonAfficher = new javax.swing.JButton();
        labelAmplitude = new javax.swing.JLabel();
        spinnerAmplitude = new javax.swing.JSpinner();
        buttonClearAll = new javax.swing.JButton();
        panelFourierSeries = new javax.swing.JPanel();
        labelNbTermes = new javax.swing.JLabel();
        spinnerNbTermesSerieFourier = new javax.swing.JSpinner();
        buttonAjouterSerieFourier = new javax.swing.JButton();
        labelPuissanceMoyenne = new javax.swing.JLabel();
        labelPuissanceMoyenneValue = new javax.swing.JLabel();
        panelPlots = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mathématiques Appliquées - Dossier 1");

        splitPaneMainFrame.setOneTouchExpandable(true);

        panelOptions.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        java.awt.GridBagLayout panelOptionsLayout = new java.awt.GridBagLayout();
        panelOptionsLayout.columnWidths = new int[] {0, 5, 0};
        panelOptionsLayout.rowHeights = new int[] {0, 3, 0, 3, 0, 3, 0};
        panelOptions.setLayout(panelOptionsLayout);

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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelOptions.add(panelDiscretiseur, gridBagConstraints);

        panelSignals.setBorder(javax.swing.BorderFactory.createTitledBorder("Paramètres des signaux"));
        java.awt.GridBagLayout panelSignalsLayout = new java.awt.GridBagLayout();
        panelSignalsLayout.columnWidths = new int[] {0, 5, 0};
        panelSignalsLayout.rowHeights = new int[] {0, 3, 0, 3, 0, 3, 0};
        panelSignals.setLayout(panelSignalsLayout);

        labelChoixSignal.setText("Choix du signal :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelSignals.add(labelChoixSignal, gridBagConstraints);

        comboBoxSignaux.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carré", "Dents de scie", "Fonction A (exercice)", "Fonction B (exercice)" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelSignals.add(comboBoxSignaux, gridBagConstraints);

        labelPeriode.setText("Période (T) :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelSignals.add(labelPeriode, gridBagConstraints);

        spinnerPeriode.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(0.0d), null, Double.valueOf(0.1d)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelSignals.add(spinnerPeriode, gridBagConstraints);

        buttonAfficher.setText("Afficher");
        buttonAfficher.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonAfficherActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelSignals.add(buttonAfficher, gridBagConstraints);

        labelAmplitude.setText("Amplitude :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelSignals.add(labelAmplitude, gridBagConstraints);

        spinnerAmplitude.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(1.0d), null, Double.valueOf(0.1d)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelSignals.add(spinnerAmplitude, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelOptions.add(panelSignals, gridBagConstraints);

        buttonClearAll.setText("Tout effacer");
        buttonClearAll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonClearAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelOptions.add(buttonClearAll, gridBagConstraints);

        panelFourierSeries.setBorder(javax.swing.BorderFactory.createTitledBorder("Paramètres de la série de Fourier"));
        java.awt.GridBagLayout panelFourierSeriesLayout = new java.awt.GridBagLayout();
        panelFourierSeriesLayout.columnWidths = new int[] {0, 5, 0};
        panelFourierSeriesLayout.rowHeights = new int[] {0, 3, 0, 3, 0};
        panelFourierSeries.setLayout(panelFourierSeriesLayout);

        labelNbTermes.setText("Nombre de termes :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelFourierSeries.add(labelNbTermes, gridBagConstraints);

        spinnerNbTermesSerieFourier.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(0), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelFourierSeries.add(spinnerNbTermesSerieFourier, gridBagConstraints);

        buttonAjouterSerieFourier.setText("Ajouter série de Fourier");
        buttonAjouterSerieFourier.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonAjouterSerieFourierActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelFourierSeries.add(buttonAjouterSerieFourier, gridBagConstraints);

        labelPuissanceMoyenne.setText("Puissance moyenne :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelFourierSeries.add(labelPuissanceMoyenne, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelFourierSeries.add(labelPuissanceMoyenneValue, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelOptions.add(panelFourierSeries, gridBagConstraints);

        splitPaneMainFrame.setLeftComponent(panelOptions);

        panelPlots.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panelPlots.setLayout(new java.awt.GridBagLayout());
        splitPaneMainFrame.setRightComponent(panelPlots);

        getContentPane().add(splitPaneMainFrame, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Events handlers">
    private void buttonClearAllActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonClearAllActionPerformed
    {//GEN-HEADEREND:event_buttonClearAllActionPerformed
        this.plotSignalSerieFourier.clear();
        this.plotSpectreSerieFourier.clear();
        this.plotRealPartTFSerieF.clear();
        this.plotImaginaryPartTFSerieF.clear();
        this.plotPhaseTFSerieF.clear();

        this.signal = null;
        this.serieFourier = null;
        this.discretiseur = null;
        this.periode = -1.0;
        this.amplitude = -1.0;
        this.signalType = null;
        this.labelPuissanceMoyenneValue.setText("");
    }//GEN-LAST:event_buttonClearAllActionPerformed

    private void buttonAfficherActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonAfficherActionPerformed
    {//GEN-HEADEREND:event_buttonAfficherActionPerformed
        // Clear all plots
        this.buttonClearAllActionPerformed(null);

        try
        {
            // Get discretiseur parameters
            int samples = (int)spinnerSamplesDisc.getValue();
            double origine = (double)this.spinnerOrigineDisc.getValue();
            double duree = (double)this.spinnerDureeDisc.getValue();
            this.discretiseur = new Discretiseur(samples, origine, duree);

            // Get signal parameters
            periode = (double)this.spinnerPeriode.getValue();
            amplitude = (double)this.spinnerAmplitude.getValue();

            // Create signal
            signalType = String.valueOf(this.comboBoxSignaux.getSelectedItem());
            switch(signalType)
            {
                case "Carré":
                    this.signal = SignalPeriodique.getInstance(
                            SignalPeriodique.CARRE, amplitude,1/periode, 0.0, discretiseur);
                    serieFourier = new CarreSerieFourier();
                    break;
                case "Dents de scie":
                    this.signal = SignalPeriodique.getInstance(
                            SignalPeriodique.SCIE, amplitude, 1/periode, 0.0, discretiseur);
                    serieFourier = new DentsScieSerieFourier();
                    break;
                case "Fonction A (exercice)":
                    this.signal = SignalPeriodique.getInstance(
                            new FonctionA(amplitude, 1/periode, 0.0), discretiseur);
                    serieFourier = new FonctionASerieFourier();
                    break;
                case "Fonction B (exercice)":
                    this.signal = SignalPeriodique.getInstance(
                            new FonctionB(amplitude, 1/periode, 0.0), discretiseur);
                    serieFourier = new FonctionBSerieFourier();
                    break;
                default:
                    throw new Exception("Signal non reconnu");
            }

            // Display signal
            this.plotSignalSerieFourier.addSignal(this.signal, signalType, false);
        }
        catch (Exception ex)
        {
            MessageBoxes.ShowError(this, ex.getMessage(), "Une erreur s'est produite");
        }
    }//GEN-LAST:event_buttonAfficherActionPerformed

    private void buttonAjouterSerieFourierActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonAjouterSerieFourierActionPerformed
    {//GEN-HEADEREND:event_buttonAjouterSerieFourierActionPerformed
        try
        {
            if (this.signal == null)
                throw new Exception("Vous devez en premier générer un signal");

            // Get the number of terms of the Fourier serie
            int n = (int)this.spinnerNbTermesSerieFourier.getValue();

            // Puissance Moyenne
            double pm = FourierSeriesBuilder.puissanceMoyenne(serieFourier, n);
            this.labelPuissanceMoyenneValue.setText(String.valueOf(pm));

            // Fourier serie
            Signal fourierSerie = FourierSeriesBuilder.fourierSerie(serieFourier, n, amplitude, periode, discretiseur);
            this.plotSignalSerieFourier.addSignal(fourierSerie, "SF " + signalType + " (N = " + String.valueOf(n)+ ")", false);

            // Get Fourier transformation of Fourier serie
            Signal TFFourierSerie = Fourier.fourier(fourierSerie);

            // Spectre
            this.plotSpectreSerieFourier.addSignal(
                TFFourierSerie.module(),
                "SF " + signalType + " (N = " + String.valueOf(n)+ ")",
                false);

            // Phase
            this.plotPhaseTFSerieF.addSignal(
                TFFourierSerie.argument(),
                "SF " + signalType + " (N = " + String.valueOf(n)+ ")",
                false);

            // Real part
            this.plotRealPartTFSerieF.addSignal(
                TFFourierSerie.partieReelle(),
                "SF " + signalType + " (N = " + String.valueOf(n)+ ")",
                false);

            // Imaginary part
            this.plotImaginaryPartTFSerieF.addSignal(
                TFFourierSerie.partieImaginaire(),
                "SF " + signalType + " (N = " + String.valueOf(n)+ ")",
                false);
        }
        catch (Exception ex)
        {
            MessageBoxes.ShowError(this, ex.getMessage(), "Une erreur s'est produite");
        }
    }//GEN-LAST:event_buttonAjouterSerieFourierActionPerformed
    //</editor-fold>

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

    private Signal signal;
    SerieFourier serieFourier;

    // For a futur Fourier series generation
    private Discretiseur discretiseur;
    private double periode;
    private double amplitude;
    private String signalType;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAfficher;
    private javax.swing.JButton buttonAjouterSerieFourier;
    private javax.swing.JButton buttonClearAll;
    private javax.swing.JComboBox comboBoxSignaux;
    private javax.swing.JLabel labelAmplitude;
    private javax.swing.JLabel labelChoixSignal;
    private javax.swing.JLabel labelDuree;
    private javax.swing.JLabel labelNbTermes;
    private javax.swing.JLabel labelOrigine;
    private javax.swing.JLabel labelPeriode;
    private javax.swing.JLabel labelPuissanceMoyenne;
    private javax.swing.JLabel labelPuissanceMoyenneValue;
    private javax.swing.JLabel labelSamples;
    private javax.swing.JPanel panelDiscretiseur;
    private javax.swing.JPanel panelFourierSeries;
    private javax.swing.JPanel panelOptions;
    private javax.swing.JPanel panelPlots;
    private javax.swing.JPanel panelSignals;
    private javax.swing.JSpinner spinnerAmplitude;
    private javax.swing.JSpinner spinnerDureeDisc;
    private javax.swing.JSpinner spinnerNbTermesSerieFourier;
    private javax.swing.JSpinner spinnerOrigineDisc;
    private javax.swing.JSpinner spinnerPeriode;
    private javax.swing.JSpinner spinnerSamplesDisc;
    private javax.swing.JSplitPane splitPaneMainFrame;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
