package workspacehub;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/splash")
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

	@RequestMapping("/")
	public String showAllSpaceTypes(Model model) {
		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());
		return "spaceTypes";
	}

	@RequestMapping("/spaceType")
	public String getOneSpaceType(@RequestParam Long id, Model model) {
		model.addAttribute("spaceType", spaceTypeRepo.findOne(id));
		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());
		return "spaceType";
	}

	public String parkingFilterButtons(@RequestParam Long id, Model model) {
		Parking selectedParking = parkingRepo.findOne(id);
		model.addAttribute("parking", parkingRepo.findOne(id));
		model.addAttribute("parking", parkingRepo.findAll());
		model.addAttribute("workSpaces", workspaceHubRepo.findAll());
		model.addAttribute("workSpaces", workspaceHubRepo.findByParking(selectedParking));
		return "parking";
	}

	@RequestMapping("/locations")


	public String getLocations(Model model) {
		model.addAttribute("workspaceHubs", workspaceHubRepo.findAll());
		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());
		return "locations";
	}

	@RequestMapping("/location")
	public String getOneLocation(@RequestParam Long id, Model model) {
		model.addAttribute("location", workspaceHubRepo.findOne(id));
		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());
		return "location";
	}

	@RequestMapping("/parking")
	public String parkingFilter(@RequestParam("id") Long id, Model model) {
		Parking selectedParking = parkingRepo.findOne(id);
		model.addAttribute("workspaceHubs", workspaceHubRepo.findByParking(selectedParking));
		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());
		return "parking";

	}

	@RequestMapping("/cost")
	public String costFilter(@RequestParam("id") Long id, Model model) {
		Cost selectedCost = costRepo.findOne(id);
		model.addAttribute("workspaceHubs", workspaceHubRepo.findByCost(selectedCost));
		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());
		return "cost";

	}

	@RequestMapping("/cost-parking")
	public String costParkingFilter(@RequestParam("cost-id") Long costId, @RequestParam("parking-id") Long parkingId,
			Model model) {
		Cost selectedCost = costRepo.findOne(costId);
		Parking selectedParking = parkingRepo.findOne(parkingId);
		model.addAttribute("workspaceHubs", workspaceHubRepo.findByCostAndParking(selectedCost, selectedParking));
		model.addAttribute("spaceTypes", spaceTypeRepo.findAll());
		return "cost-parking";

	}

	@RequestMapping("/about-us")
	public String aboutUs() {
		return "about-us";
	}

}