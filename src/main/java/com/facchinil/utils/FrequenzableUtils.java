package com.facchinil.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.collections4.CollectionUtils;

import com.facchinil.dto.Frequenzable;

public class FrequenzableUtils {
	
	private FrequenzableUtils() {
	    throw new IllegalStateException();
	  }

	public static <A extends Frequenzable> A getRandomElementFromList(List<A> list) {
		if(CollectionUtils.isEmpty(list))
			return null;
		if(list.stream().anyMatch(f -> f.getFrequenzaCumulativa() == null))
			fillFrequenzaCumulativa(list);
		int value = ThreadLocalRandom.current().nextInt(list.get(list.size() - 1).getFrequenzaCumulativa());
		return list.stream()
				.filter(c -> c.getFrequenzaCumulativa() >= value)
				.findFirst().orElse(null);
	}
	
	private static <T extends Frequenzable> Integer fillFrequenzaCumulativa(List<T> list) {
		if(CollectionUtils.isEmpty(list))
			return 0;
		list.get(0).setFrequenzaCumulativa(list.get(0).getFrequenza());
		for(int i = 1; i < list.size(); i++)
			list.get(i).setFrequenzaCumulativa(list.get(i).getFrequenza() + list.get(i - 1).getFrequenzaCumulativa());
		return list.get(list.size() - 1).getFrequenzaCumulativa();
	}

}
