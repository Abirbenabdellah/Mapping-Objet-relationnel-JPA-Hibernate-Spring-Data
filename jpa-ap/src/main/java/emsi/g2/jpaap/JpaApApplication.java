package emsi.g2.jpaap;

import emsi.g2.jpaap.entities.Patient;
import emsi.g2.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
@Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(JpaApApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<70;i++) {
            patientRepository.save(new Patient(null, "abir",
                    new Date(), Math.random()>0.5?true:false,
                    (int)Math.random()*100));
        }
        Page<Patient> p=patientRepository.findAll(PageRequest.of(0,4));
        System.out.println("total pages:"+p.getTotalPages());
        System.out.println("total elements:"+p.getTotalElements());
        System.out.println("numero page:"+p.getNumber());
        List<Patient> content=p.getContent();
        Page<Patient> bymalade=patientRepository.findByMalade
                (true,PageRequest.of(0,4));
        List<Patient> patientList=patientRepository.chercherpatients("%b%",45);
        bymalade.forEach(i->{
            System.out.println("************");
            System.out.println(i.getId());
            System.out.println(i.getNom());
            System.out.println(i.getScore());
            System.out.println(i.getDateNaissance());
        });
        System.out.println("************");
        Patient pa=patientRepository.findById(1L).orElse(null);
        if(pa!=null){
            System.out.println(pa.getId());
            System.out.println(pa.getNom());
            System.out.println(pa.getScore());
            System.out.println(pa.getDateNaissance());
        }
        pa.setScore(69);
        patientRepository.save(pa);
        patientRepository.deleteById(3L);

    }
}
