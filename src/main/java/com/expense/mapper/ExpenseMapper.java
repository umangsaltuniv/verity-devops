package com.expense.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.expense.dto.ExpenseDTO;
import com.expense.entity.Expense;

/*
 * Data Transfer Object to Entity and vice versa mapping
 */
@Component
public class ExpenseMapper {

	@Autowired
	private ModelMapper modelMapper;

	/*
	 * Entity to DTO
	 */
	public ExpenseDTO modelToDTOMap(Expense model) {
		return modelMapper.map(model, ExpenseDTO.class);
	}

	/*
	 * DTO to Entity
	 */

	public Expense dtoToModelMap(ExpenseDTO dto) {
		return modelMapper.map(dto, Expense.class);
	}

	/*
	 * Entity list to DTO list
	 */
	public List<ExpenseDTO> modelToDTOList(List<Expense> modelList) {
		return modelList.stream().map(material -> modelToDTOMap(material)).collect(Collectors.toList());
	}

	/*
	 * DTO List to Entity
	 */

	public List<Expense> dtoToModelList(List<ExpenseDTO> dtoList) {
		return dtoList.stream().map(materialDTO -> dtoToModelMap(materialDTO)).collect(Collectors.toList());
	}

}
