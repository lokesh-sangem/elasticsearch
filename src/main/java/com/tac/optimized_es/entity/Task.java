package com.tac.optimized_es.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Pattern;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName="optimizedes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @Id
    private String id = String.valueOf(System.currentTimeMillis());// Generates ID based on current time
    private String name;
    private String task;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    private String logHours;

//    private String duration;

    private String day;

    @Enumerated(EnumType.STRING)
    private TaskStatus status; // Using enum instead of string


    private Long date;

    @JsonProperty("date")
    public String getFormattedDate() {
        if (this.date != null) {
            return Instant.ofEpochMilli(this.date)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()
                    .toString(); // Converts to yyyy-MM-dd format
        }
        return null; // Return null if date is null
    }

    @JsonProperty("date")
    public void setFormattedDate(Long date) {
        this.date = date;
    }
//
//    private Long time;
////    Time getter and setter with current time default
//    @JsonProperty("time")
//    public String getFormattedTime() {
//        long effectiveTime = (this.time != null) ? this.time : System.currentTimeMillis();
//        return Instant.ofEpochMilli(effectiveTime)
//                .atZone(ZoneId.systemDefault())
//                .toLocalTime()
//                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//    }
//
//    @JsonProperty("time")
//    public void setFormattedTime(Long time) {
//        this.time = time;
//    }


    private Long time; // Stores the time in milliseconds since epoch

    @JsonProperty("time")
    public String getFormattedTime() {
        long effectiveTime = (this.time != null) ? this.time : System.currentTimeMillis();
        return Instant.ofEpochMilli(effectiveTime)
                .atZone(ZoneId.of("Asia/Kolkata")) // Set to Indian Standard Time
                .toLocalTime()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")); // Formats to HH:mm:ss
    }

    @JsonProperty("time")
    public void setFormattedTime(Long time) {
        this.time = time;
    }


}






