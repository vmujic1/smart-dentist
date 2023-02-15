package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.MaterijaliManager;
import ba.unsa.etf.rpr.business.RasporedManager;
import ba.unsa.etf.rpr.domain.Materijali;
import ba.unsa.etf.rpr.domain.NarudzbePacijenata;
import ba.unsa.etf.rpr.exceptions.SmartDentistException;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * CLI(Command Line Interface) impl
 * @author vmujic1
 */
public class App {

  private static final Option dodajPacijentauRaspored = new Option("dodajP", "dodaj-pacijent-raspored", false, "Dodavanje novog pacijenta u raspored");
  private static final Option obrisiPacijentaIzRasporeda = new Option("obrisiP", "obrisi-pacijenta-raspored", false, "Brisanje pacijenta iz rasporeda");
  private static final Option dajSvePacijenteIzRasporeda = new Option("dajSveP", "daj-pacijente", false, "Vracanje svih pacijenata iz rasporeda");

  private static final Option dodajMaterijaluSkladiste = new Option("dodajM", "dodaj-materijal-skladiste", false, "Dodavanje novog materijala u skladiste");
  private static final Option obrisiMaterijalIzSkladista = new Option("obrisiM", "obrisi-materijal-skladiste", false, "Brisanje materijala iz skladista");
  private static final Option dajSveMaterijaleIzSkladista = new Option("dajSveM", "daj-materijale", false, "Vracanje svih materijala iz skladista");


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

  public static void main(String[] args) throws ParseException, SmartDentistException {
    Options options = addOptions();
    CommandLineParser commandLineParser = new DefaultParser();
    CommandLine cl = commandLineParser.parse(options, args);
    RasporedManager rm = new RasporedManager();
    MaterijaliManager mm = new MaterijaliManager();

    if (cl.hasOption(dodajPacijentauRaspored.getOpt()) || cl.hasOption(dodajPacijentauRaspored.getLongOpt())) {
      try {
        NarudzbePacijenata n = new NarudzbePacijenata();
        n.setIme(cl.getArgList().get(0));
        n.setPrezime(cl.getArgList().get(1));
        n.setPovod(cl.getArgList().get(2));
        n.setDatum(LocalDate.parse(cl.getArgList().get(3)));
        RasporedManager.add(n);
        System.out.println("Nova stavka uspjesno dodana u raspored!");
      } catch (Exception e) {
        System.out.println("Greska. Pokusajte opet.");
        printFormattedOptions(options);
        System.exit(-1);
      }
    } else if (cl.hasOption(obrisiPacijentaIzRasporeda.getOpt()) || cl.hasOption(obrisiPacijentaIzRasporeda.getLongOpt())) {
      NarudzbePacijenata n = new NarudzbePacijenata();
      try {
        n = RasporedManager.getByName(cl.getArgList().get(0));
        RasporedManager.delete(n.getId());
        System.out.println("Stavka uspjesno obirsana iz rasporeda");
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Pacijent sa tim imenom ne postoji u rasporedu!");

      } catch (SmartDentistException e) {
        System.out.println("Greska. Pokusajte opet");
      }
    } else if (cl.hasOption(dajSveMaterijaleIzSkladista.getOpt()) || cl.hasOption(dajSvePacijenteIzRasporeda.getLongOpt())) {
      NarudzbePacijenata n1 = new NarudzbePacijenata();

      RasporedManager.getAll().forEach(n-> System.out.println(n1.getIme()));
    } else if (cl.hasOption(dodajMaterijaluSkladiste.getOpt()) || cl.hasOption(dodajMaterijaluSkladiste.getLongOpt())) {
      try {
        Materijali m = new Materijali();
        m.setNaziv(cl.getArgList().get(0));
        m.setKoličina(Integer.parseInt(cl.getArgList().get(1)));
        MaterijaliManager.add(m);
        System.out.println("Stavka uspjesno dodana u skladiste!");
      } catch (Exception e) {
        System.out.println("Greska. Pokusajte opet.");
      }
    } else if (cl.hasOption(obrisiMaterijalIzSkladista.getOpt()) || cl.hasOption(obrisiMaterijalIzSkladista.getLongOpt())) {
      Materijali m = new Materijali();
      try {
        m = MaterijaliManager.getByName(cl.getArgList().get(0));
        RasporedManager.delete(m.getId());
        System.out.println("Stavka uspjesno obirsana iz skladista");
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Stavka sa tim imenom ne postoji u skladistu!");

      } catch (SmartDentistException e) {
        System.out.println("Greska. Pokusajte opet");
      }
    } else if (cl.hasOption(dajSveMaterijaleIzSkladista.getOpt()) || cl.hasOption(dajSveMaterijaleIzSkladista.getLongOpt())) {
      {
        RasporedManager.getAll().forEach(m -> System.out.println(m.getIme()));
      }
    } else {
      printFormattedOptions(options);
      System.exit(-1);
    }
  }
}


