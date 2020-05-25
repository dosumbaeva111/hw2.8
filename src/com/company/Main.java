package com.company;

import java.util.*;

public class Main {
    //# ДЗ (Дэдлайн 25.05.2020 23:59)
//Копировать все элементы словаря в большой словарь как они есть.
//Затем нужно написать алгоритм автоматического дополнения большого словаря, таким образом чтоб каждый из элементов
// массива синонимов по 1 разу выступил в роли КЛЮЧА
//Текущие ключи маленького словаря также должны будут перейти в массив на роль одного из синонимов.
//Подсказка массив легко конвертируется в ArrayList, для проверки правильности работы вашего алгоритма
// в конце распечатайте содержимое всего большого словаря

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("большой", new String[]{"огромный", "громадный", "великий", "колосальный"});
        dictionary.put("человек", new String[]{"персона", "миледи", "личность", "гражданин"});
        dictionary.put("красивый", new String[]{"привлекательный", "обоятельный", "симпатичный", "прекрасный", "приятный"});
        dictionary.put("дом", new String[]{"квартира", "жилище", "вилла", "комуналка", "хата", "особняк"});

        HashMap<String, String[]> bigDictionary = new HashMap<>();
        Set<String> keyWords = dictionary.keySet();
        Iterator iterator = keyWords.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String[] word = dictionary.get(key);
            bigDictionary.put(key, word);
            for (int i = 0; i < word.length; i++) {
                String newKye = word[i];
                ArrayList<String> newWords = new ArrayList<>();
                newWords.addAll(Arrays.asList(word));
                newWords.remove(newKye);
                newWords.add(key);
                String[] arrayConverter = new String[word.length];
                arrayConverter = newWords.toArray(new String[0]);
                bigDictionary.put(newKye, arrayConverter);

            }
        }


        System.out.println("Введите любое слово из словаря:");
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = bigDictionary.get(words[i]);
            if (synonyms != null) {
                Random random = new Random();
                int randomIndex = random.nextInt(synonyms.length);
                System.out.print(synonyms[randomIndex] + " ");
            } else {
                System.out.print("Слово не найдено ");
            }
        }

    }
}



