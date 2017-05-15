package de.hawhh.informatik.sml.kino.werkzeuge.zahlung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZahlungsWerkzeugUI
{
	private static final String TITEL = "Zahlung";

	protected JDialog _dialog;

	protected JLabel _gesamtBetragLabel;
	protected JFormattedTextField _gezahltTextField;
	protected JLabel _nochZuZahlenLabel;

	protected JButton _okButton;
	protected JButton _abbrechenButton;

	public ZahlungsWerkzeugUI(JFrame owner)
	{
		_dialog = new JDialog(owner, TITEL);
		_dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		_dialog.getContentPane().setLayout(new BorderLayout());

		
		_dialog.getContentPane().add(erstelleButtonPanel(), BorderLayout.SOUTH);
		_dialog.getContentPane().add(erstelleRechnungsPanel(), BorderLayout.CENTER);
	}

	private JComponent erstelleRechnungsPanel()
	{
		JComponent rechnungsPanel = new JPanel();
		rechnungsPanel
		        .setLayout(new BoxLayout(rechnungsPanel, BoxLayout.Y_AXIS));
		
		_gesamtBetragLabel = new JLabel("Gesamtbetrag: \txx.xx €");
		
		JComponent gezahltPanel = new JPanel(new FlowLayout());
		JLabel gezahltLabel = new JLabel("Gezahlt: \t");
		gezahltPanel.add(gezahltLabel);
		
		_gezahltTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance(Locale.GERMANY));
		_gezahltTextField.setMaximumSize(new Dimension(150, 20));
		_gezahltTextField.setValue(new Double(0));
		
		gezahltPanel.add(_gezahltTextField);
		
		_nochZuZahlenLabel = new JLabel("Noch zu zahlen: \txx.xx €");
		
		rechnungsPanel.add(_gesamtBetragLabel);
		rechnungsPanel.add(gezahltPanel);
		rechnungsPanel.add(_nochZuZahlenLabel);
		return rechnungsPanel;
	}
	
	private JComponent erstelleButtonPanel()
	{
		JComponent buttonPanel = new JPanel(new FlowLayout());
		_okButton = new JButton("OK");
		_okButton.setEnabled(false);
		_abbrechenButton = new JButton("Abbrechen");
		buttonPanel.add(_abbrechenButton);
		buttonPanel.add(_okButton);
		
		return buttonPanel;
	}
	

	/*
	public JButton getAbbrechenButton()
	{
		return _abbrechenButton;
	}
	
	public JButton getOkButton()
	{
		return _okButton;
	}
	
	public JFormattedTextField getGezahltTextField()
	{
		return _gezahltTextField;
	}
	
	
	public JLabel getNochZuZahlenLabel()
	{
		return _nochZuZahlenLabel;
	}
	
	public JLabel getZuZahlenLabel()
	{
		return _zuZahlenLabel;
	}
	*/
	
    /**
     * Zeigt das Fenster an.
     */
    public void zeigeFenster()
    {
        _dialog.pack();
        _dialog.setVisible(true);
    }

    /**
     * Schließt das Fenster.
     */
    public void schliesseFenster()
    {
        _dialog.dispose();
    }
}
