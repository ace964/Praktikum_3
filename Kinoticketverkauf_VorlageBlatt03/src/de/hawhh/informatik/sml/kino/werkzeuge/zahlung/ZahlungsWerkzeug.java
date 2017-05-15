package de.hawhh.informatik.sml.kino.werkzeuge.zahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

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
		_ui.zeigeFenster();
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
		int iBetrag = 0;
		if(_ui._gezahltTextField.getValue() instanceof Double)
		{
			Double betrag = (Double) _ui._gezahltTextField.getValue();
			iBetrag = (int) Math.round(betrag*100);
		}
		else
		{
			Long betrag = (Long) _ui._gezahltTextField.getValue();
			iBetrag = (int) (betrag*100);
		}
		
		double nochZuZahlen = (double)(_zahlungsBetrag - iBetrag) / 100D;
		
		_ui._okButton.setEnabled(nochZuZahlen <= 0);
		
		_ui._nochZuZahlenLabel.setText(String.format("Noch zu zahlen: %.2f €", nochZuZahlen));
	}
	
	private void aktualisiereGesamtbetragLabel()
	{
		double gesamtbetrag = (double)_zahlungsBetrag / 100D;
		_ui._gesamtBetragLabel.setText(String.format("Gesamtbetrag: %.2f €",gesamtbetrag));
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
		_ui._gezahltTextField.addPropertyChangeListener(new PropertyChangeListener()
		{
			
			@Override
			public void propertyChange(PropertyChangeEvent arg0)
			{
				reagiereAufTextEingabe();
				
			}
		});
		
		_ui._dialog.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentMoved(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent arg0)
			{
				reagiereAufAbbrechenButtonKlick();
				
			}
		});
	}
}
