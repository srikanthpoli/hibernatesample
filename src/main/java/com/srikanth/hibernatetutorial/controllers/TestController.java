//package com.srikanth.hibernatetutorial.controllers;
//
//import com.srikanth.hibernatetutorial.HibernateTutorialApplication;
//import com.srikanth.hibernatetutorial.entities.entities.onetoone.InstructorDetailEntity;
//import com.srikanth.hibernatetutorial.entities.entities.onetoone.InstructorEntity;
//import com.srikanth.hibernatetutorial.entities.entities.onetoone.StudentEntity;
//import com.srikanth.hibernatetutorial.models.LogLevel;
//import com.srikanth.hibernatetutorial.services.TestService;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.LoggerContext;
//import org.apache.logging.log4j.core.config.Configuration;
//import org.apache.logging.log4j.core.config.LoggerConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/sample")
//public class TestController {
//
//    private static final Logger LOGGER = LogManager.getLogger(HibernateTutorialApplication.class);
//    @Autowired
//    private TestService testService;
//
//
//    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
//    public String createEmployeeList() {
//        testService.createStudent();
//
//        return "Ok";
//    }
//
//    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
//    public List<StudentEntity> getEmployeeList() {
//        return testService.getStudentList();
//
//    }
//
//    @GetMapping("/log")
//    public String log() {
//
//
//        LOGGER.trace("This is a TRACE level message");
//        LOGGER.debug("This is a DEBUG level message");
//        LOGGER.info("This is an INFO level message");
//        LOGGER.warn("This is a WARN level message");
//        LOGGER.error("This is an ERROR level message");
//        return "See the log for details";
//    }
//
//    @RequestMapping(value = "/chnagelogger", method = RequestMethod.POST)
//    public void chnagelogger(@RequestBody LogLevel loglevel) {
//        Logger logger = LogManager.getLogger(loglevel.getLogger());
//        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
//        final Configuration config = ctx.getConfiguration();
//        LoggerConfig loggerConfig = config.getLoggerConfig(logger.getName());
//        LoggerConfig specificConfig = loggerConfig;
//        if (!loggerConfig.getName().equals(logger.getName())) {
//            specificConfig = new LoggerConfig(logger.getName(), Level.valueOf(loglevel.getLoglevel())
//                    , true);
//            specificConfig.setParent(loggerConfig);
//            config.addLogger(logger.getName(), specificConfig);
//        }
//        specificConfig.setLevel(Level.valueOf(loglevel.getLoglevel()));
//        ctx.updateLoggers();
//    }
//
//    @RequestMapping(value = "/getStudentsByID/{id}", method = RequestMethod.GET)
//    public StudentEntity getEmployeeByID(@PathVariable int id) {
//        return testService.getStudentLByID(id);
//
//    }
//
//    @RequestMapping(value = "/deleteStudentsByID/{id}", method = RequestMethod.POST)
//    public void deleteStudentsByID(@PathVariable int id) {
//        testService.deleteStudentLByID(id);
//
//    }
//
//    @RequestMapping(value = "/updateStdudentQuery", method = RequestMethod.GET)
//    public void updateStdudentQuery() {
//        testService.updateStudentQuery();
//
//    }
//
//    @RequestMapping(value = "/getStudentsByName", method = RequestMethod.GET)
//    public List<StudentEntity> getEmployeeByName() {
//        return testService.getStudentLByName();
//
//    }
//    @RequestMapping(value = "/craeteInstructor", method = RequestMethod.POST)
//    public void createInstructor(@RequestBody InstructorEntity instructorEntity) {
//         testService.insertInstructor(instructorEntity);
//
//    }
//    @RequestMapping(value = "/deleteInstructor/{instructorID}", method = RequestMethod.DELETE)
//    public void deleteInstrctorByID(@PathVariable int instructorID) {
//        testService.deleteInstrctorByID(instructorID);
//
//    }
//    @RequestMapping(value = "/getInstructionDetail/{id}", method = RequestMethod.GET)
//    public InstructorDetailEntity getInstructorDetail(@PathVariable int id) {
//        return testService.getInstructorDetailID(id);
//
//    }
//
//    @RequestMapping(value = "/getInstructorBYID/{id}", method = RequestMethod.GET)
//    public InstructorEntity getInstructor(@PathVariable int id) {
//        return testService.getInstructorByID(id);
//
//    }
//
//    @RequestMapping(value = "/deletenstructionDetail/{id}", method = RequestMethod.DELETE)
//    public void deletenstructionDetail(@PathVariable int id) {
//         testService.deleteInstructorDetailID(id);
//
//    }
//}
