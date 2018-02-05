package edu.mum.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Session;
import edu.mum.service.SessionService;

/**
 * @author 985727 on 11/20/2017
 */
@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostConstruct
    public void populateCustomers() {
//		List<Roles> roles = new ArrayList<>();
//		roles.add(Roles.COUNCELOR);
//		Address address = new Address("1234", "123", "123", 52365, "213123");
//		Person person = new Person("123", "`1234", "`1234", "123", "123", address, roles);
//		Location location = new Location("1234", 34);
//		List<Session> sessions = new ArrayList<>();
//		sessions.add(new Session(new Date(), LocalDate.now(), LocalDate.now(), 34, location, person));
//		sessions.add(new Session(new Date(), LocalDate.now(), LocalDate.now(), 34, location, person));
//		sessions.add(new Session(new Date(), LocalDate.now(), LocalDate.now(), 34, location, person));
//		sessions.add(new Session(new Date(), LocalDate.now(), LocalDate.now(), 34, location, person));
//		sessionService.saveAll(sessions);
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Session> getSessions() {
        return sessionService.find();
    }

    @RequestMapping(value = "/{sessionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Session getSession(@PathVariable int sessionId) {
        return sessionService.get(sessionId);
    }

    @RequestMapping(value = "/{sessionId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteSession(@PathVariable int sessionId) {

        JSONObject responseBody = new JSONObject();
        HttpStatus httpStatus = HttpStatus.OK;

//        ToDo check it on service
        if (new Date().before(sessionService.get(sessionId).getDate())) {
            responseBody.put("message", "Session date has passed");
            responseBody.put("sessionId", sessionId);
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            sessionService.delete(sessionId);
            responseBody.put("message", "Successfully deleted");
            responseBody.put("sessionId", sessionId);

        }

//        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        responseBody.put("message", "Unable to delete due internal server error");
//        responseBody.put("sessionId", sessionId);


        return new ResponseEntity<String>(responseBody.toString(), httpStatus);
    }

    @RequestMapping(value = "/{sessionId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateSession(@PathVariable int sessionId, @RequestBody Session session) {
        Session savedSession = sessionService.get(sessionId);

        JSONObject responseBody = new JSONObject();
        HttpStatus httpStatus = HttpStatus.OK;

        if (savedSession == null) {
            responseBody.put("message", "Session not found");
            responseBody.put("sessionId", sessionId);
            httpStatus = HttpStatus.BAD_REQUEST;
        } else if (new Date().before(savedSession.getDate())) {
            responseBody.put("message", "Session date has passed");
            responseBody.put("sessionId", sessionId);
            httpStatus = HttpStatus.BAD_REQUEST;
//		} else if (!session.getPerson().getPersonRoles().contains(COUNCELOR)) {
//			responseBody.put("message", "User does not have 'COUNCELOR' role");
//			responseBody.put("sessionId", sessionId);
//			httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            savedSession.setDate(session.getDate());
            savedSession.setDuration(session.getDuration());
            savedSession.setLocation(session.getLocation());
            savedSession.setNumberofsits(session.getNumberofsits());
            savedSession.setPerson(session.getPerson());
            savedSession.setStartTime(session.getStartTime());
            sessionService.update(savedSession);

            responseBody.put("message", "Session successfully updated");
            responseBody.put("session", new JSONObject(savedSession));
            httpStatus = HttpStatus.OK;
        }
        // add Error part
        return new ResponseEntity<String>(responseBody.toString(), httpStatus);
    }

}
