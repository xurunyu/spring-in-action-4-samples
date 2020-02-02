package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles(Model model) {
//        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max",
                    defaultValue= "0x7fffffffffffffffL") long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String showSpittle(
            @PathVariable long spittleId,
                    Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        spittleRepository.save(new Spittle(form.getMessage(), new Date(), form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }
}
