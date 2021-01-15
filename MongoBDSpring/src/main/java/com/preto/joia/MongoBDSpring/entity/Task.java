package com.preto.joia.MongoBDSpring.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.preto.joia.MongoBDSpring.AuditingModel;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data -- Trazer todos os getters e setters
//@Builder -- utilizado para a construção da classe
//@AllArgsConstructor -- gera um Boilerplate  construtor com argumentos
//@NoArgsConstructor -- gera um Boilerplate  construtor sem argumentos
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Document(collection = "tasks")
public class Task extends AuditingModel {

	private String title;
	private Boolean done;

	public Task(String _id, String title, Boolean done) {
		super();
		this.title = title;
		this.done = done;
	}

	public Task() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

}
