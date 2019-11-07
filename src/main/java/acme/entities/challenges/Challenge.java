
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Future
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	@Pattern(regexp = "^GOLD$")
	private String				goldEn;

	@NotBlank
	@Pattern(regexp = "^ORO$")
	private String				goldEs;

	@NotNull
	private double				rewardGold;

	@NotBlank
	@Pattern(regexp = "^SILVER$")
	private String				silverEn;

	@NotBlank
	@Pattern(regexp = "^PLATA$")
	private String				silverEs;

	@NotNull
	private double				rewardSilver;

	@NotBlank
	@Pattern(regexp = "^BRONZE$")
	private String				bronzeEn;

	@NotBlank
	@Pattern(regexp = "^BRONCE$")
	private String				bronzeEs;

	@NotNull
	private double				rewardBronze;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
