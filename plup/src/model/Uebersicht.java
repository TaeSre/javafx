package model;

import java.util.List;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@SuppressWarnings("rawtypes")
public class Uebersicht extends TableView{
	
	private TableColumn <Generator, String> standort;
	private TableColumn <Generator, Double> nennLeistung;
	private TableColumn <Kraftwerksanlage, String> generatoren;
	private TableColumn <Kraftwerksanlage, Double > aktuelleLeistung;
	
	
	public Uebersicht()
	{
		init();
		addComp();
		setFact();
	}
	
	private void init() {
		standort = new TableColumn<>("Standort");
		nennLeistung = new TableColumn<>("Nenn Leistung");
		generatoren = new TableColumn<>("Generatortyp");
		aktuelleLeistung = new TableColumn<>("Aktuelle Leistung");
	}
	
	@SuppressWarnings("unchecked")
	private void addComp()
	{
		getColumns().addAll(standort, nennLeistung, generatoren, aktuelleLeistung);
	}
	
	@SuppressWarnings({ "unchecked" })
	private void setFact()
	{
		standort.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getStandort()));
		nennLeistung.setCellValueFactory(c -> new ReadOnlyObjectWrapper(c.getValue().getNennLeistung()));
		generatoren.setCellValueFactory(new PropertyValueFactory<>("generatoren"));
		aktuelleLeistung.setCellValueFactory(new PropertyValueFactory<>("aktuelleLeistung"));
		
	}
	
	@SuppressWarnings("unchecked")
	public void setAllg(List<Generator> modListe)
	{
		getItems().setAll(modListe);
	}
	
	
}
