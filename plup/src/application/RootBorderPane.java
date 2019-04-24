package application;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Kraftwerksanlage;
import model.Uebersicht;

public class RootBorderPane extends BorderPane
{
	
	private MenuBar menuBar;
	private Menu menuDatei, menuGeneratoren, menuSetRunning;
	private MenuItem miLaden, miSpeichern, miImportieren, miExportieren, miBeenden,
				     miLoeschen, miRunningEin, miRunningAus;
	private Uebersicht uebersicht;
	
	
	
	private void initComponents()
	{
		menuBar = new MenuBar();
		
		menuDatei = new Menu("Datei");
		menuGeneratoren = new Menu("Generatoren");
		menuSetRunning = new Menu("Set running");
		
		miLaden = new MenuItem("Laden");
		miSpeichern = new MenuItem("Speichern");
		miImportieren = new MenuItem("Importieren");
		miExportieren = new MenuItem("Exportieren");
		miBeenden = new MenuItem("Beenden");
		
		miRunningEin = new MenuItem("ein");
		miRunningAus = new MenuItem("aus");
		miLoeschen = new MenuItem("Löschen");
		
		uebersicht = new Uebersicht();
		
		
	}

	private void addComp()
	{
	
		menuSetRunning.getItems().addAll(miRunningEin, miRunningAus);
		
		menuGeneratoren.getItems().addAll(menuSetRunning, miLoeschen);
		
		menuDatei.getItems().addAll(miLaden, miSpeichern, miImportieren, miExportieren, miBeenden);
		
		menuBar.getMenus().addAll(menuDatei, menuGeneratoren );
		
		setTop(menuBar);
		
		setCenter(uebersicht);
		
	}
	
	public RootBorderPane()
	{
		initComponents();
		addComp();
		addListeners();
		
		
	}

	private void addListeners()
	{
		miBeenden.setOnAction(e -> Platform.exit() );
		miSpeichern.setOnAction(e -> saveFile() );
		miLaden.setOnAction(e -> openFile());
		
	}

	private void openFile() {
		FileChooser fc = new FileChooser();
		fc.setTitle("File to open");
		fc.setInitialDirectory(new File("c:\\scratch"));
		File selected = fc.showOpenDialog(null);
		
		if(selected == null)
		{
			Main.createAlert(AlertType.WARNING, "Fehler");
		}
		else {
			if(selected.isFile())
			{
				try {
					Kraftwerksanlage.loadGeneratoren(selected.getAbsolutePath());
					
					
				} catch (Exception e) {
					Main.createAlert(AlertType.WARNING, e.getMessage());
					
				}
			}
			else
			{
				Main.createAlert(AlertType.WARNING, "Falsch");
			}
		}
		
	}

	private void saveFile() {
		FileChooser fc = new FileChooser();
		fc.setTitle("File to save");
		fc.setInitialDirectory(new File("c:\\scratch"));
		File selected = fc.showSaveDialog(null);
		
		if(selected == null)
		{
			Main.createAlert(AlertType.WARNING, "Fehler");
		}
		else {
			System.out.println("Gespeichert!");
		}
		
	}





}





