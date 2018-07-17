package se.abalon;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import se.abalon.dto.OfferDTO;
import se.abalon.dto.RedeemOfferDTO;
import se.abalon.exception.EntityNotFoundException;
import se.abalon.exception.UnableToRedeemException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * Tests are on ignore as i removed valid customer id for security
 *
 * @throws EntityNotFoundException
 */

@Ignore
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"spring.cloud.config.enabled:false", "eureka.client.enabled:false"})
@Rollback()
public class LandingApplicationTests  {

	@Value("http://localhost:${local.server.port}")
	public String host;

	@Autowired
	private CheckService checkService;

	private LandingController landingController;



	@Before
	public void initialize() {

		landingController = new LandingController(checkService);
	}

	/**
	 *
	 * Tests the endpoint to retrieve all valid offers for a customer, via the Landing Controller.
	 *
	 * @throws EntityNotFoundException
	 */
	@Test
	public void testGetOffers() throws EntityNotFoundException {

		List<OfferDTO> offerDTOS = landingController.getOffers("test", "customer id goes here");

		assertThat(offerDTOS.get(0).getCode().equals("offerCode"));
	}

	/**
	 *
	 * Tests the endpoint to redeem a specific offer, via the Landing Controller.
	 *
	 * @throws se.abalon.exception.UnableToRedeemException and EntityNotFoundException
	 */
	@Test
	public void testRedeemOffer() throws UnableToRedeemException, EntityNotFoundException {
		List<OfferDTO> offerDTOS = landingController.getOffers("test", "customer id goes here");

		RedeemOfferDTO redeemOfferDTO = landingController.redeemOffer(offerDTOS.get(0), "test", "customer id goes here");

		assertThat(redeemOfferDTO.getMemberId().equals("customer id goes here"));
	}

}
