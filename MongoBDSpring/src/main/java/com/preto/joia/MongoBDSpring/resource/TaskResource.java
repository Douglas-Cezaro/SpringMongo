package com.preto.joia.MongoBDSpring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.preto.joia.MongoBDSpring.entity.Task;
import com.preto.joia.MongoBDSpring.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskResource {

	// Serve para instanciar o repository em tempo de execução
	@Autowired
	private TaskRepository taskRepository;

	public TaskResource(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@GetMapping
	@ResponseBody
	public List<Task> findAll() {
		return this.taskRepository.findAll();
	}

	@PostMapping
	@ResponseBody
	public Task create(@RequestBody Task task) {
		return this.taskRepository.save(task);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Task> findOne(@PathVariable String id){
		return this.taskRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void delete(@PathVariable String id) {
		this.taskRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity update(@PathVariable String id, @RequestBody Task task) {
		return this.taskRepository.findById(id)
				.map(record -> {
					record.setTitle(task.getTitle());
					record.setDone(task.getDone());
					Task updated = this.taskRepository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
