package kr.co.sist.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PaginationDTO {

	private int pageNumber, currentPage, totalPage;
	private String url,field, keyword;
}
