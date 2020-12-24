package com.tokoin.repository.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tokoin.model.Ticket;
import com.tokoin.repository.TicketRepository;

public class TicketRepositoryImpl implements TicketRepository{

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findTicketByTerm() {
		List<Ticket> tickets = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\com\\tokoin\\resources\\tickets.json"));
			Type collectionType = new TypeToken<Collection<Ticket>>(){}.getType(); 
			tickets = (List<Ticket>) new Gson().fromJson(br, collectionType); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tickets;
	}

}
