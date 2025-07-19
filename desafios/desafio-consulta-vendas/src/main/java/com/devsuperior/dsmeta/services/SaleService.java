package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Sale sale = repository.findById(id).get();
		return new SaleMinDTO(sale);
	}

	public Page<SaleReportDTO> getReport(String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		LocalDate max = (maxDate == null || maxDate.equals("")) ? today : LocalDate.parse(maxDate);
		LocalDate min = (minDate == null || minDate.equals("")) ? max.minusYears(1L) : LocalDate.parse(minDate);
		String nameParam = (name == null) ? "" : name;

		Page<Sale> result = repository.searchReport(min, max, nameParam, pageable);
		return result.map(s -> new SaleReportDTO(s));
	}

	public List<SaleSummaryDTO> getSummary(String minDate, String maxDate) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		LocalDate max = (maxDate == null || maxDate.equals("")) ? today : LocalDate.parse(maxDate);
		LocalDate min = (minDate == null || minDate.equals("")) ? max.minusYears(1L) : LocalDate.parse(minDate);

		return repository.searchSummary(min, max);
	}
}
