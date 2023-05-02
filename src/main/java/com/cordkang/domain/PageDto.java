package com.cordkang.domain;

import lombok.Data;

@Data
public class PageDto {
	
	
	// �ϴܿ� ��� �� ������ ������
	private int pageCount = 10;
	
	// ���������� ���� 
	private int startPage;
	
	// ���������� ���� 
	private int endPage;
	
	
    // �Խñ� �Ѱ��� 
	
	private int total;
	
	// next, prev
	private boolean prev;
	private boolean next;
	
	private boolean doublePrev;
	private boolean doubleNext;
	// Criteria
	private Criteria cri;


	public PageDto(int total, Criteria cri) {
		this(10, total, cri);
	}


	public PageDto(int pageCount, int total, Criteria cri) {
		
		this.pageCount = pageCount;
		this.total = total;
		this.cri = cri;
//		cri.getAmount()
//		cri.getPageNum()
//		total
		// 11 > 20
		// 1 > 10
		// 3 > 10
		
		endPage = (cri.getPageNum() + (pageCount-1)) / pageCount * pageCount;
		startPage = endPage - (pageCount-1);
        int realEnd = (total + (cri.getAmount() - 1)) / cri.getAmount();
//        System.out.println(realEnd);
        if(endPage > realEnd) {
        	endPage = realEnd;
        }
        prev = cri.getPageNum() > 1;
        next = cri.getPageNum() < realEnd;
        
        doublePrev = startPage > 1;
        doubleNext = endPage < realEnd;
	}
	
//	public static void main(String[] args) {
//		Criteria cri = new Criteria(11, 10);
//	    PageDto page = new PageDto(223, cri);
//		System.out.println(page);
//	}
	
	
	
	
	// ����  <<, >>
	
  }
