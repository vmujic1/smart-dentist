import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.PrintWriter;

/**
 * CLI(Command Line Interface) impl
 * @author vmujic1
 */
public class App {

  private static final Option dodajPacijentauRaspored = new Option("dodajP", "dodaj-pacijent-raspored", false, "Dodavanje novog pacijenta u raspored");
  private static final Option obrisiPacijentaIzRasporeda = new Option("obrisiP", "obrisi-pacijenta-raspored",false,"Brisanje pacijenta iz rasporeda");
  private static final Option dajSvePacijenteIzRasporeda = new Option("dajSveP", "daj-pacijente",false,"Vracanje svih pacijenata iz rasporeda");

  private static final Option dodajMaterijaluSkladiste = new Option("dodajM", "dodaj-materijal-skladiste", false, "Dodavanje novog materijala u skladiste");
  private static final Option obrisiMaterijalIzSkladista = new Option("obrisiM", "obrisi-materijal-skladiste",false,"Brisanje materijala iz skladista");
  private static final Option dajSveMaterijaleIzSkladista = new Option("dajSveM", "daj-materijale",false,"Vracanje svih materijala iz skladista");


  public static void printFormattedOptions(Options options) {
    HelpFormatter helpFormatter = new HelpFormatter();
    PrintWriter printWriter = new PrintWriter(System.out);
    helpFormatter.printUsage(printWriter, 150, "java -jar smart-dentist-cli-jar-with-dependencies.jar [option] (parameters)");
    helpFormatter.printOptions(printWriter, 150, options, 2, 7);
    printWriter.close();
  }

  public static Options addOptions() {
    Options options = new Options();
    options.addOption(dodajPacijentauRaspored);
    options.addOption(obrisiPacijentaIzRasporeda);
    options.addOption(dajSvePacijenteIzRasporeda);
    options.addOption(dodajMaterijaluSkladiste);
    options.addOption(obrisiMaterijalIzSkladista);
    options.addOption(dajSveMaterijaleIzSkladista);
    return options;
  }

}
