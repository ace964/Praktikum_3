package de.hawhh.informatik.sml.kino.werkzeuge.zahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import de.hawhh.informatik.sml.kino.werkzeuge.ObservableSubwerkzeug;

public class ZahlungsWerkzeug extends ObservableSubwerkzeug
{

	private ZahlungsWerkzeugUI _ui;
	private int _zahlungsBetrag;
	
	private boolean _bezahlt;

	public ZahlungsWerkzeug(JFrame owner)
	{
		_zahlungsBetrag = 0;
		_ui = new ZahlungsWerkzeugUI(owner);
		_bezahlt = false;
		registriereUIAktionen();
	}
	
	public void beginneZahlvorgang(int zahlungsBetrag)
	{
		_zahlungsBetrag = zahlungsBetrag;
		_bezahlt = false;
		aktualisiereGesamtbetragLabel();
		_ui._gezahltTextField.setValue(new Double(0));
		aktualisiereNochZuZahlenLabel();
	}
	
	private void reagiereAufOkButtonKlick()
	{
		_ui.schliesseFenster();
		_bezahlt = true;
		informiereUeberAenderung();
	}
	
	private void reagiereAufAbbrechenButtonKlick()
	{
		_ui.schliesseFenster();
		_bezahlt = false;
		informiereUeberAenderung();
	}
	
	private void reagiereAufTextEingabe()
	{
		aktualisiereNochZuZahlenLabel();
	}
	
	private void aktualisiereNochZuZahlenLabel()
	{
		Double betrag = (Double) _ui._gezahltTextField.getValue();
		int iBetrag = (int) Math.round(betrag*100);
		
		double nochZuZahlen = (double)(_zahlungsBetrag - iBetrag) / 100D;
		
		_ui._okButton.setEnabled(nochZuZahlen < 0);
		
		_ui._nochZuZahlenLabel.setText("Noch zu zahlen: \t" + nochZuZahlen + " €");
	}
	
	private void aktualisiereGesamtbetragLabel()
	{
		double gesamtbetrag = (double)_zahlungsBetrag / 100D;
		_ui._gesamtBetragLabel.setText("Gesamtbetrag: \t" + gesamtbetrag + " €");
	}
	
	public boolean isBezahlt()
	{
		return _bezahlt;
	}
	
	private void registriereUIAktionen()
	{
		
		_ui._okButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				reagiereAufOkButtonKlick();
			}
		});
		
		_ui._abbrechenButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				reagiereAufAbbrechenButtonKlick();
				
			}
		});
		_ui._gezahltTextField.getDocument().addDocumentListener(new DocumentListener()
		{
			
			@Override
			public void removeUpdate(DocumentEvent e)
			{
				reagiereAufTextEingabe();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				reagiereAufTextEingabe();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e)
			{
				reagiereAufTextEingabe();
			}
		});
	}
}
