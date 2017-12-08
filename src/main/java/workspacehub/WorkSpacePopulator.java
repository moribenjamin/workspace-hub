package workspacehub;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WorkSpacePopulator implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(WorkSpacePopulator.class);

	@Resource
	private WorkSpaceHubRepository workspaceHubRepo;
	@Resource
	private FeatureRepository featureRepo;
	@Resource
	private SpaceTypeRepository spaceTypeRepo;
	@Resource
	private HoursRepository hoursRepo;
	@Resource
	private ParkingRepository parkingRepo;
	@Resource
	private CapacityRepository capacityRepo;
	@Resource
	private CostRepository costRepo;

	@Override
	public void run(String... args) throws Exception {
		SpaceType coworkingSpace = new SpaceType("Co-working Space", "/images/workspace.jpg");
		spaceTypeRepo.save(coworkingSpace);
		SpaceType coffeeShop = new SpaceType("Coffee Shop", "/images/espressomachine.jpg");
		spaceTypeRepo.save(coffeeShop);
		SpaceType library = new SpaceType("Library", "/images/library.jpg");
		spaceTypeRepo.save(library);

		Hours hours1 = new Hours("Monday, Tuesday, Wednesday, Thursday, Friday, 8AM- 6PM");
		hoursRepo.save(hours1);
		Hours hours2 = new Hours("Monday, Tuesday, Wednesday, Thursday, Friday, 9AM- 6PM");
		hoursRepo.save(hours2);
		Hours hours3 = new Hours("Monday, Tuesday, Wednesday, Thursday, Friday,Saturday, 24 hrs");
		hoursRepo.save(hours3);
		Hours hours4 = new Hours("Monday, Tuesday, Wednesday, Thursday, Friday, 9AM- 5PM");
		hoursRepo.save(hours4);
		Hours hours5 = new Hours("Monday, Tuesday, Wednesday, Thursday, Friday,Saturday, 7AM- 9:30PM, Sunday, 7AM-8PM");
		hoursRepo.save(hours5);
		Hours hours6 = new Hours("Monday, Tuesday, Wednesday, Thursday, Friday, 3PM- 9PM,Sat-Su, 10AM-3PM");
		hoursRepo.save(hours6);
		Hours hours7 = new Hours("Monday, Tuesday, Wednesday, Thursday, 9AM- 9PM,F-S, 9AM-6PM, Su 1-5PM");
		hoursRepo.save(hours7);
		Hours hours8 = new Hours("Monday, Tuesday, Wednesday, 5AM-10PM, Th-F 5AM -11PM, Saturday, Sunday, 5:30-10PM");
		hoursRepo.save(hours8);
		Hours hours9 = new Hours("Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, 6AM-9PM, Sunday, 7AM-9PM");
		hoursRepo.save(hours9);
		Hours hours10 = new Hours("Monday, Tuesday, Wednesday, Thursday, Friday, 7AM-7PM, Saturday, Sunday, 8AM-7PM");

		hoursRepo.save(hours10);

		Parking garage = new Parking("garage");
		parkingRepo.save(garage);
		Parking freeStreet = new Parking("Free street");
		parkingRepo.save(freeStreet);
		Parking onSite = new Parking("On-site ");
		parkingRepo.save(onSite);

		Cost free = new Cost("free");
		costRepo.save(free);
		Cost expensive = new Cost("$49/day");
		costRepo.save(expensive);
		Cost moderate = new Cost("$15/day");
		costRepo.save(moderate);
		Cost moderateHigh = new Cost("$25/day");
		costRepo.save(moderateHigh);
		Cost coffee = new Cost("Coffee");
		costRepo.save(coffee);

		Capacity cap = new Capacity("100");
		capacityRepo.save(cap);

		workspaceHubRepo.save(new WorkspaceHub("\"Serendipity Labs\"", "Serendipity Labs",
				"/images/workspace/serendipity-labs/serendipityinside.jpg", "info@csuitesoffices.com",
				"http://serendipitylabs.com", "https://www.facebook.com/SerendipityLabsColumbus/",
				"twitter.com/columbusohlabs", "\"21 E State St, Columbus, OH, 43215\"","21 E. State Street","Columbus, OH 43215", "(614) 705-2212", "djskdkjsak",
				coworkingSpace, hours1, garage, expensive, cap));
		workspaceHubRepo.save(
				new WorkspaceHub("\"Saltmines South\"", "Saltmines South", "/images/workspace/saltmines-south/saltmines-south-inside.png",
						"email", "http://2997indianola.spaces.nexudus.com/en", "https://www.facebook.com/TheSaltMines/",
						"twitter.com/thesaltmines", "\"2997 Indianola, Columbus, OH, 43202\"", "2997 Indianola Avenue","Columbus, OH 43202", "(614) 859-9559", "djskdkjsak", coworkingSpace,
						hours2, freeStreet, moderate, cap));
		workspaceHubRepo.save(
				new WorkspaceHub("\"Saltmines North\"","Saltmines North", "/images/workspace/saltmines-north/saltmines-north-inside.png",
						"email", "http://3820highstreet.spaces.nexudus.com/en",
						"https://www.facebook.com/TheSaltMines/", "twitter.com/thesaltmines", "\"3820 N High Street, Columbus, OH, 43214\"", "3820 N High Street","Columbus, OH 43214",
						"(614) 859-9559", "djskdkjsak", coworkingSpace, hours2, freeStreet, moderate, cap));
		workspaceHubRepo.save(new WorkspaceHub("\"The Perch\"","The Perch", "/images/workspace/perch/1.jpg",
				"work@theperchshortnorth.com", "theperchshortnorth.com", "https://www.facebook.com/theperchshortnorth/",
				"twitter.com/coworkcolumbus", "\"45 E Lincoln St, Columbus, OH, 43215\"","45 E Lincoln Street","Columbus, OH 43215", "(614) 769-7131", "djskdkjsak",
				coworkingSpace, hours3, onSite, moderate, cap));
		workspaceHubRepo.save(new WorkspaceHub("\"The Hub on Kenney\"","The Hub on Kenney", "/images/workspace/hub/hubinside.jpg", "email",
				"thehubonkenny.com", "https://www.facebook.com/thehubonkenny/", "twitter.com/thehubonkenny",
				"\"4510 Kenny Rd, Columbus, OH, 43220\"","4510 Kenny Road","Columbus, OH 43220", "(614) 845-5001", "djskdkjsak", coworkingSpace, hours4, onSite,
				moderate, cap));
		workspaceHubRepo.save(new WorkspaceHub("\"Cup O Joe Coffee House\"","Cup O Joe Coffee House", "/images/coffee/cup-o-joe/cupojoeinside.jpg",
				"email", "http://www.cupojoe.com/", "https://www.facebook.com/cupojoecoffee/",
				"twitter.com/cupojoecoffee ", "\"2990 N High St, Columbus, OH, 43202\"","2990 N High Street","Columbus, OH 43202", "(614) 225-1563", "djskdkjsak",
				coffeeShop, hours5, onSite, coffee, cap));
		workspaceHubRepo.save(new WorkspaceHub("\"Starbucks Clintonville\"","Starbucks Clintonville", "images/coffee/starbucks/starbucksinside.jpg",
				"email",
				"https://www.starbucks.com/store-locator/store/1011597/north-high-and-east-torrence-3580-north-high-street-columbus-oh-43214-us",
				"https://www.facebook.com/Starbucks/", "twitter.com/starbucks", "\"3580 N High St, Columbus, OH ,43214\"","3580 N High Street","Columbus, OH 43214",
				"(614) 263-1292", "djskdkjsak", coffeeShop, hours8, onSite, coffee, cap));
		workspaceHubRepo.save(
				new WorkspaceHub("\"Crimson Cup Clintonville\"","Crimson Cup Clintonville", "/images/coffee/crimson-cup/crimsoninside.jpg", "email",
						"https://www.crimsoncup.com/about/clintonville", "https://www.facebook.com/crimsoncup/",
						"twitter.com/crimsoncup", "\"4541 N High St, Columbus, OH, 43214\"","4541 N High Street","Columbus, OH 43214", "(614) 262-6212", "djskdkjsak",
						coffeeShop, hours9, onSite, coffee, cap));
		workspaceHubRepo
				.save(new WorkspaceHub("\"Giant Eagle Market District\"","Giant Eagle Market District", "/images/coffee/giant-eagle/gianteagleinside.jpg",
						"email", "https://www.marketdistrict.com/", "https://www.facebook.com/marketdistrict/",
						"twitter.com/marketdistrict", "\"840 W 3rd Ave, Columbus, OH, 43212\"","840 W 3rd Avenue","Columbus, OH 43212", "(614) 294-2186",
						"djskdkjsak", coffeeShop, hours10, onSite, coffee, cap));
		workspaceHubRepo.save(new WorkspaceHub("\"Mission Coffee\"", "Mission Coffee", "/images/coffee/mission-coffee/missioninside.jpg",
				"email", "https://www.missioncoffeeco.com/", "https://www.facebook.com/missioncoffeeco/",
				"twitter.com/missioncolumbus", "\"11 Price Ave, Columbus, OH, 43201\"","11 Price Avenue","Columbus, OH 4320", "(614) 300-0648", "djskdkjsak",
				coffeeShop, hours2, freeStreet, coffee, cap));
		workspaceHubRepo
				.save(new WorkspaceHub("\"The Point-Otterbein University\"","The Point-Otterbein University", "/images/library/the-point/point_inside-4.jpg",
						"email", "https://otterbeinpoint.com/", "https://www.facebook.com/OtterbeinPoint/",
						"twitter.com/otterbeinpoint", "\"60 Collegeview Rd, Westerville, OH, 43081\"","60 Collegeview Road","Westerville, OH 43081", "(614) 823-1420",
						"djskdkjsak", library, hours7, onSite, moderateHigh, cap));
		workspaceHubRepo.save(new WorkspaceHub("\"Whetstone Library\"","Whetstone Library", "/images/library/whetstone/whetstoneinside.png", "email", "http://www.columbuslibrary.org/",
				"https://www.facebook.com/Columbus-Metropolitan-Library-Whetstone-Branch-142655732432937/",
				"twitter.com/columbuslibrary", "\"3909 N. High Street, Columbus, OH, 43214\"","3909 N. High Street","Columbus, OH, 43214", "(614) 645-2275",
				"djskdkjsak", library, hours6, onSite, free, cap));
		workspaceHubRepo
				.save(new WorkspaceHub("\"Columbus Metropolitan Library\"","Columbus Metropolitan Library", "/images/library/columbus-metro/567246699_6f8b6db75d_b.jpg",
						"email", "http://www.columbuslibrary.org/", "https://www.facebook.com/columbuslibrary/",
						"twitter.com/columbuslibrary", "\"96 S. Grant Avenue, Columbus, OH, 43215\"","96 S. Grant Avenue","Columbus, OH 43215", "(614) 645-2275",
						"djskdkjsak", library, hours7, garage, free, cap));
		workspaceHubRepo.save(new WorkspaceHub("\"Northside Branch-Columbus Library\"","Northside Branch-Columbus Library",
				"/images/library/northside-branch/northside branch library meeting rooom.jpg", "email",
				"http://www.columbuslibrary.org/",
				"https://www.facebook.com/Columbus-Metropolitan-Library-Northside-Branch-111841245519790/",
				"twitter.com/columbuslibrary", "\"1423 N High St, Columbus, OH, 43201\"","1423 N. High Street","Columbus, OH 43201", "(614) 645-2275", "djskdkjsak",
				library, hours7, freeStreet, free, cap));
		workspaceHubRepo.save(new WorkspaceHub("\"Worthington Library\"","Worthington Library",
				"/images/library/worthington/Worthington_meeting_rooms.jpg", "email", "worthingtonlibraries.org",
				"https://www.facebook.com/Worthington-Library-10150095364585704/", "twitter.com/worthingtonlib",
				"\"820 High Street, Worthington, OH, 43085\"","820 High Street","Worthington, OH 43085", "614-807-2626", "djskdkjsak", library, hours7, onSite, free,
				cap));

		
		log.info("Parking Garage");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByParking(garage)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Free Street Parking");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByParking(freeStreet)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("On-site");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByParking(onSite)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Free Workspace");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCost(free)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Expensively Priced Workspace");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCost(expensive)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Moderately Priced Workspace");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCost(moderate)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Moderately High-Priced Workspace");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCost(moderateHigh)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Coffee Purchased Necessary");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCost(coffee)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Free Workspaces with Garages");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(free, garage)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Free Workspaces with Parking Lots");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(free, onSite)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Free Workspaces with Street Parking");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(free, freeStreet)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Expensive Workspaces with Garages");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(expensive, garage)) {
			log.info(workspacehub.toString());
		}
		log.info("");

		log.info("Moderately Priced Workspaces with Street Parking");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(moderate, freeStreet)) {
			log.info(workspacehub.toString());
		}

		log.info("");

		log.info("Moderately Priced Workspaces with Parking Lot");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(moderate, onSite)) {
			log.info(workspacehub.toString());
		}

		log.info("");

		log.info("Moderately High-Priced Workspaces with Parking Lot");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(moderateHigh, onSite)) {
			log.info(workspacehub.toString());
		}

		log.info("");

		log.info("Coffee Purchased Necessary and Parking Lot");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(coffee, onSite)) {
			log.info(workspacehub.toString());
		}

		log.info("");

		log.info("Coffee Purchased Necessary and Street Parking");
		log.info("--------------------------------------------");
		for (WorkspaceHub workspacehub : workspaceHubRepo.findByCostAndParking(coffee, freeStreet)) {
			log.info(workspacehub.toString());
		}
		
		log.info("");
	}
}