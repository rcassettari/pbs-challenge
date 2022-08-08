package com.pbs.challenge.finantial.manualmovements.infrasctructure.persistence.repository;

import com.pbs.challenge.finantial.manualmovements.domain.model.ManualMovement;
import com.pbs.challenge.finantial.manualmovements.domain.model.ManualMovementId;
import com.pbs.challenge.finantial.manualmovements.domain.repository.ManualMovementRepository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualMovementRepositoryImpl extends ManualMovementRepository, JpaRepository<ManualMovement, ManualMovementId> {

	ManualMovement save(ManualMovement manualMovement);

	@Query(" from ManualMovement "
			+ "order by manualMovementId.year, manualMovementId.monthOfYear , manualMovementId.number asc ")
	List<ManualMovement> findAllOrderByYearMonthOfYearNumberAsc();

	@Query(" select max(manualMovementId.number) + 1 from ManualMovement where "
			+ " manualMovementId.year = :year and manualMovementId.monthOfYear = :monthOfYear ")
	BigDecimal findMaxNoteNumberByYearMonthOfYear( @Param("year") BigDecimal year, @Param("monthOfYear") BigDecimal monthOfYear );

}