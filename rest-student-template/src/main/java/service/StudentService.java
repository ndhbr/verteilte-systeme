package service;

import entity.Student;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("/studentaffairs/students")
public class StudentService {

    private static int nextStudentId = 1;
    private static Map<Integer, Student> studentDb = new HashMap<Integer, Student>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student matriculate(Student s) {
        s.setMatrikelNr(nextStudentId++);
        studentDb.put(s.getMatrikelNr(), s);

        return s;
    }

    @DELETE
    @Path("{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student exmatriculate(@PathParam("studentId") int studentId) {
        if (studentDb.containsKey(studentId)) {
            Student student = studentDb.remove(studentId);

            return student;
        }

        throw new IllegalStateException("this student does not exist");
    }

    @GET
    @Path("{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("studentId") int studentId) {
        if (!studentDb.containsKey(studentId)) {
            throw new NotFoundException("this student does not exist");
        }

        return studentDb.get(studentId);
    }

    @PUT
    @Path("{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudentAccount(@PathParam("studentId") int studentId, Student newData) {
        if (studentDb.containsKey(studentId)) {
            studentDb.put(studentId, newData);

            return newData;
        } else {
            throw new IllegalStateException("this student does not exist");
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Student> getAllStudents() {
        return studentDb.values();
    }

    @GET
    @Path("range")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Student> getStudentsByRange(@QueryParam("from") int fromStudentId,
            @QueryParam("to") int toStudentId) {
        ArrayList<Student> list = new ArrayList<Student>();

        for (Map.Entry<Integer, Student> student : studentDb.entrySet()) {
            if (student.getKey() >= fromStudentId && student.getKey() <= toStudentId) {
                list.add(student.getValue());
            }
        }

        return list;
    }
}
