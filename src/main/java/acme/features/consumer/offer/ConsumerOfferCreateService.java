
package acme.features.consumer.offer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ConsumerOfferRepository repository;


	// AbstractCreateService<Consumer, Offer> interface ---------------

	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "deadline", "minReward", "maxReward", "description");
	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		Offer result;

		result = new Offer();

		return result;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		Date creationMoment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(creationMoment);
		this.repository.save(entity);
	}

}
