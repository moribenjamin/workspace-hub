package workspacehub;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkSpaceController {

	@Resource
	CapacityRepository capacityRepo;

	@Resource
	CostRepository costRepo;

	@Resource
	FeatureRepository featureRepo;

	@Resource
	HoursRepository hoursRepo;

	@Resource
	ParkingRepository parkingRepo;

	@Resource
	SpaceTypeRepository spaceTypeRepo;

	@Resource
	WorkSpaceHubRepository workspaceHubRepo;

	@RequestMapping("/")
	public String showAllClasses(Model model) {

		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());

		model.addAttribute("spaceType", spaceTypeRepo.findAll());

		model.addAttribute("workspaceHubs", workspaceHubRepo.findAll());
		model.addAttribute("parking", parkingRepo.findAll());
		model.addAttribute("hours", hoursRepo.findAll());
		model.addAttribute("features", featureRepo.findAll());
		model.addAttribute("cost", costRepo.findAll());
		model.addAttribute("capacity", capacityRepo.findAll());
		return "splashPage";
	}

	@RequestMapping("/spaceTypes")
	public String showAllSpaceTypes(Model model) {
		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());
		return "spaceTypes";
	}

	@RequestMapping("/spaceType")
	public String getOneSpaceType(@RequestParam Long id, Model model) {
		model.addAttribute("spaceType", spaceTypeRepo.findOne(id));
		return "spaceType";
	}

	@RequestMapping("/locations")
	public String getLocations(Model model) {
		model.addAttribute("workspaceHubs", workspaceHubRepo.findAll());
		return "locations";
	}
	/*@RequestMapping(value = "/js", method = RequestMethod.GET)
    public String getExampleJS(Model model) {
        model.addAttribute();
        return "studentCheck.js";
    }*/
	

	@RequestMapping("/location")
	public String getOneLocation(@RequestParam Long id, Model model) {
		model.addAttribute("location", workspaceHubRepo.findOne(id));
		return "location";

	}
}