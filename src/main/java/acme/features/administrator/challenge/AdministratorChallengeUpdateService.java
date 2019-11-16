
package acme.features.administrator.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenge> {

	//InternalState
	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getGoldEn() == "GOLD") {
			entity.setGoldEs("ORO");
		}

		if (entity.getGoldEs() == "ORO") {
			entity.setGoldEn("GOLD");
		}

		if (entity.getSilverEn() == "SILVER") {
			entity.setSilverEs("PLATA");
		}

		if (entity.getSilverEs() == "PLATA") {
			entity.setSilverEn("SILVER");
		}

		if (entity.getBronzeEn() == "BRONZE") {
			entity.setBronzeEs("BRONCE");
		}

		if (entity.getBronzeEs() == "BRONCE") {
			entity.setBronzeEn("BRONZE");
		}

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goldEn", "goldEs", "rewardGold", "silverEn", "silverEs", "rewardSilver", "bronzeEn", "bronzeEs", "rewardBronze");

	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;
		Challenge result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneChallengeById(id);

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		if (entity.getGoldEn() == "GOLD") {
			entity.setGoldEs("ORO");
		}

		if (entity.getGoldEs() == "ORO") {
			entity.setGoldEn("GOLD");
		}

		if (entity.getSilverEn() == "SILVER") {
			entity.setSilverEs("PLATA");
		}

		if (entity.getSilverEs() == "PLATA") {
			entity.setSilverEn("SILVER");
		}

		if (entity.getBronzeEn() == "BRONZE") {
			entity.setBronzeEs("BRONCE");
		}

		if (entity.getBronzeEs() == "BRONCE") {
			entity.setBronzeEn("BRONZE");
		}

		this.repository.save(entity);

	}

}
