package eu.jensghysel.babysite.controllers;

import eu.jensghysel.babysite.controllers.response.GenderSummaryResponse;
import eu.jensghysel.babysite.models.BabyGok;
import eu.jensghysel.babysite.repositories.BabyGokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class BabyGokController {
    @Autowired
    private BabyGokRepository repository;

    @PostMapping("/gok")
    public BabyGok store(@RequestBody BabyGok gok){
        List<BabyGok> gokjesWithEmail = repository.findAllByEmail(gok.getEmail());
        if(gokjesWithEmail.size() > 0){
            throw new IllegalArgumentException("Email already used");
        }
        return repository.save(gok);
    }

    @GetMapping("/gok")
    public List<BabyGok> getAll(){
        return repository.findAll();
    }

    @GetMapping("/gok/gender")
    public GenderSummaryResponse genderSummaryResponse(){
        List<BabyGok> gokjes = repository.findAll();
        double boyVotes = gokjes.stream().filter(b -> b.getGender().toLowerCase().equals("boy")).count();
        double boyPercentage = (boyVotes / gokjes.size()) * 100;
        return GenderSummaryResponse.builder().percentageBoys(boyPercentage).percentageGirls(100 - boyPercentage).build();
    }
}
