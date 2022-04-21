package com.nucleus.endpoint;



import com.nucleus.models.soap.emp.GetEmployeeRequest;
import com.nucleus.models.soap.emp.GetEmployeeResponse;
import com.nucleus.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


    @Endpoint
    public class EmployeeEndpoint {
        private static final String NAMESPACE_URI = "http://nucleus.com/models/soap/emp";

        private EmployeeRepository empRepository;

        @Autowired
        public EmployeeEndpoint(EmployeeRepository empRepository) {
            this.empRepository = empRepository;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
        @ResponsePayload
        public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
            GetEmployeeResponse response = new GetEmployeeResponse();
            response.setEmployee(empRepository.findEmployee(request.getId()));

            return response;
        }

}
