package vezbe.demo.configuration;

import org.hibernate.type.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.*;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.time.*;
import java.util.*;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private Tip_kupcaRepository tip_kupcaRepository;

    @Autowired
    private ArtikalPorudzbinaRepository artikalporudzbinaRepository;



    @Bean
    public boolean instantiate(){
        Lokacija lokacija1 = new Lokacija(19.20, 45.46, "Bulevar oslobodjenja 102");
        Lokacija lokacija2 = new Lokacija(19.20, 45.46, "Bulevar oslobodjenja 119");
        Lokacija lokacija3 = new Lokacija(19.20, 45.46, "Sentandrejski put 11");

        lokacijaRepository.save(lokacija1);
        lokacijaRepository.save(lokacija2);
        lokacijaRepository.save(lokacija3);

        Restoran restoran1 = new Restoran("Brunch", "all", lokacija1);
        Restoran restoran2 = new Restoran("FastFood 88", "kineski", lokacija2);
        Restoran restoran3 = new Restoran("McDonalds", "fastfood", lokacija3);
        //restoran1.setLokacija(lokacija1);
        //restoran2.setLokacija(lokacija2);

        restoranRepository.saveAll(List.of(restoran1, restoran2, restoran3));

        Artikal artikal1 = new Artikal("Pizza", 1000, Tip_artikla.JELO, 1, "delicious", restoran2);
        Artikal artikal2 = new Artikal("Pasta", 560, Tip_artikla.JELO, 1, "yummy", restoran3);
        Artikal artikal3 = new Artikal("Salata", 600, Tip_artikla.JELO, 1, "healthy", restoran1);
        Artikal artikal4 = new Artikal("Cola Zero", 200, Tip_artikla.PICE, 1, "cola", restoran3);

        artikalRepository.save(artikal1);
        artikalRepository.save(artikal2);
        artikalRepository.save(artikal3);
        artikalRepository.save(artikal4);



        Tip_kupca tip_kupca1 = new Tip_kupca(Ime_tip_kupca.ZLATNI, 55, 100);
        Tip_kupca tip_kupca2 = new Tip_kupca(Ime_tip_kupca.SREBRNI, 35, 75);
        Tip_kupca tip_kupca3 = new Tip_kupca(Ime_tip_kupca.BRONZANI, 25, 50);

        tip_kupcaRepository.save(tip_kupca1);
        tip_kupcaRepository.save(tip_kupca2);
        tip_kupcaRepository.save(tip_kupca3);



        //Korisnik korisnik1 = new Korisnik("Tamara123", Pol.Z , "ranisovic123", "Tamara", "Ranisovic", new Date(101, Calendar.JULY, 27), Uloga.KUPAC);
        //Korisnik korisnik2 = new Korisnik("Petar10", Pol.M , "petrovic10", "Petar", "Petrovic", new Date(100, Calendar.MAY, 22), Uloga.KUPAC);
        //Korisnik korisnik3 = new Korisnik("MarkoM", Pol.M , "markovic", "Marko", "Markovic", new Date(98, Calendar.OCTOBER, 20), Uloga.MENADZER);
        //Korisnik korisnik4 = new Korisnik("IvanaI", Pol.Z , "ivanica", "Ivana", "Ivanovic", new Date(95, Calendar.AUGUST, 15), Uloga.DOSTAVLJAC);
        //Korisnik korisnik5 = new Korisnik("Milica654", Pol.Z , "milica1", "Milica", "Milic", new Date(95, Calendar.JANUARY, 10), Uloga.DOSTAVLJAC);
        //Korisnik korisnik6 = new Korisnik("Tijana123", Pol.Z , "15641s", "Tijana", "Petrovic", new Date(99, Calendar.MARCH, 8), Uloga.KUPAC);

        //korisnikRepository.saveAll(List.of(korisnik1, korisnik2, korisnik3, korisnik4, korisnik5, korisnik6));

        Admin admin1 = new Admin("Marina", Pol.Z , "marina100", "Marina", "Maric",  new Date(102, Calendar.JULY, 30));

        adminRepository.save(admin1);

        Kupac kupac1 = new Kupac("Tamara123", Pol.Z , "ranisovic123", "Tamara", "Ranisovic",  new Date(101, Calendar.JULY, 27));
        Kupac kupac2 = new Kupac("Petar10", Pol.M , "petrovic10", "Petar", "Petrovic", new Date(100, Calendar.MAY, 22));
        Kupac kupac3 = new Kupac("Tijana123", Pol.Z , "15641s", "Tijana", "Petrovic", new Date(99, Calendar.MARCH, 8));


        kupac1.setTip_kupca(tip_kupca3);
        kupac2.setTip_kupca(tip_kupca3);
        kupac3.setTip_kupca(tip_kupca3);

        kupacRepository.saveAll(List.of(kupac1, kupac2, kupac3));

        Menadzer menadzer1 = new Menadzer("MarkoM", Pol.M , "markovic", "Marko", "Markovic", new Date(98, Calendar.OCTOBER, 20), restoran1);
        Menadzer menadzer2 = new Menadzer("Nikola", Pol.M , "NIkoLa", "Nikola", "Nikolic", new Date(95, Calendar.DECEMBER, 26), restoran2);
        Menadzer menadzer3 = new Menadzer("TijanaP", Pol.M , "Tijana456", "Tijana", "Petrovic", new Date(92, Calendar.JULY, 5), restoran3);

        // menadzer1.setRestoran(restoran1);
        menadzerRepository.saveAll(List.of(menadzer1, menadzer2, menadzer3));

        Dostavljac dostavljac1 = new Dostavljac("IvanaI", Pol.Z , "ivanica", "Ivana", "Ivanovic", new Date(95, Calendar.AUGUST, 15));
        Dostavljac dostavljac2 = new Dostavljac("Milica654", Pol.Z , "milica1", "Milica", "Milic", new Date(95, Calendar.JANUARY, 10));

        dostavljacRepository.saveAll(List.of(dostavljac1, dostavljac2));





        Porudzbina porudzbina1 = new Porudzbina(LocalDateTime.of(2022, Month.MAY, 2, 19, 30, 40), 150, kupac1, dostavljac1,  restoran1);
        Porudzbina porudzbina2 = new Porudzbina(LocalDateTime.of(2022, Month.MAY, 2, 18, 39, 44), 150, kupac2, dostavljac2, restoran3);
        Porudzbina porudzbina3 = new Porudzbina(LocalDateTime.of(2022, Month.MAY, 2, 14, 30, 00), 150, kupac1, dostavljac2, restoran3);
        Porudzbina porudzbina4 = new Porudzbina(LocalDateTime.of(2022, Month.MAY, 2, 20, 55, 30), 150, kupac2, dostavljac2, restoran2);
        Porudzbina porudzbina5 = new Porudzbina(LocalDateTime.of(2022, Month.MAY, 2, 22, 05, 36), 150, kupac1, dostavljac1, restoran2);
        Porudzbina porudzbina6 = new Porudzbina(LocalDateTime.of(2022, Month.MAY, 2, 15, 18, 29), 150, kupac3, dostavljac1, restoran1);

        porudzbinaRepository.saveAll(List.of(porudzbina1, porudzbina2, porudzbina3, porudzbina4, porudzbina5, porudzbina6));

        ArtikalPorudzbina artikalPorudzbina1 = new ArtikalPorudzbina(4, porudzbina1, artikal1);
        ArtikalPorudzbina artikalPorudzbina2 = new ArtikalPorudzbina(1, porudzbina3, artikal2);
        ArtikalPorudzbina artikalPorudzbina3 = new ArtikalPorudzbina(2, porudzbina4, artikal3);
        ArtikalPorudzbina artikalPorudzbina4 = new ArtikalPorudzbina(1, porudzbina5, artikal1);
        ArtikalPorudzbina artikalPorudzbina5 = new ArtikalPorudzbina(3, porudzbina2, artikal4);
        ArtikalPorudzbina artikalPorudzbina6 = new ArtikalPorudzbina(4, porudzbina6, artikal2);

        artikalporudzbinaRepository.saveAll(List.of(artikalPorudzbina1, artikalPorudzbina2, artikalPorudzbina3, artikalPorudzbina4, artikalPorudzbina5, artikalPorudzbina6));


        Komentar komentar1 = new Komentar(kupac1, restoran3, "odlicno!", 5);
        Komentar komentar2 = new Komentar(kupac2, restoran2, "super", 5);
        Komentar komentar3 = new Komentar(kupac3, restoran1, "ukusna hrana!", 5);
        Komentar komentar4 = new Komentar(kupac1, restoran1, "savrseno", 5);
        Komentar komentar5 = new Komentar(kupac2, restoran1, "okej!", 4);


        komentarRepository.saveAll(List.of(komentar1, komentar2, komentar3, komentar4, komentar5));

        /*Department department1 = new Department("first department");
        Department department2 = new Department("second department");

        department1.setCompany(company);
        department2.setCompany(company)
        departmentRepository.saveAll(
                List.of(department1, department2)
        );

        Employee pera = new Employee(
                "Pera", "Peric", "Rukovodilac", department1
        );
        Employee mika = new Employee(
                "Mika", "Mikic", "Menadzer", department1
        );
        Employee zika = new Employee(
                "Zika", "Zikic", "Radnik", department2
        );

        employeeRepository.saveAll(
                List.of(pera, mika, zika)
        );

        Project project1 = new Project(
                "Projekat 1", new Date(125, Calendar.JULY, 4)
        );

        Project project2 = new Project(
                "Projekat 2", new Date(129, Calendar.DECEMBER, 3)
        );

        projectRepository.saveAll(
                List.of(project1, project2)
        );

        mika.getProjects().add(project1);
        mika.getProjects().add(project2);

        zika.getProjects().add(project2);

        employeeRepository.save(mika);
        employeeRepository.save(zika);
*/
        return true;
    }
}