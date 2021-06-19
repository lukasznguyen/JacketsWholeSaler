package com.example.jacketwholesaler.models;

import com.example.jacketwholesaler.models.entities.*;
import com.example.jacketwholesaler.models.enums.Color;
import com.example.jacketwholesaler.models.enums.Size;
import com.example.jacketwholesaler.repositories.CustomerRepository;
import com.example.jacketwholesaler.repositories.EmployeeRepository;
import com.example.jacketwholesaler.repositories.JacketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class DatabaseDataSeeder implements CommandLineRunner {

    //Repositories
    private final JacketRepository jacketRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;

    //DataFiles
    private final String jacketFile = "src/main/resources/static/dbseeder/jacket.txt";
    private final String manualEmpFile = "src/main/resources/static/dbseeder/manual_employee.txt";
    private final String customerServEmpFile = "src/main/resources/static/dbseeder/customer_service_employee.txt";
    private final String normalCustomerFile = "src/main/resources/static/dbseeder/normal_customer.txt";
    private final String companyFile = "src/main/resources/static/dbseeder/company.txt";

    //Lists
    private List<Jacket> jackets = new ArrayList<>();
    private List<ManualEmployee> manualEmployees = new ArrayList<>();
    private List<CustomerServiceEmployee> customerServiceEmployees = new ArrayList<>();
    private List<NormalCustomer> normalCustomers = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();

    //Others
    private final String delimiter = ";";
    private final String languagesDelimiter = ",";
    private BufferedReader bfr;
    private String line;
    private String[] dividedLine;

    @Autowired
    public DatabaseDataSeeder(JacketRepository jacketRepository, EmployeeRepository employeeRepository, CustomerRepository customerRepository) {
        this.jacketRepository = jacketRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        FileReader jacketIS = new FileReader(jacketFile);
        loadJackets(jacketIS);
        FileReader manualEmpIS = new FileReader(manualEmpFile);
        loadManualEmps(manualEmpIS);
        FileReader customerSerEmpIS = new FileReader(customerServEmpFile);
        loadCustomerSerEmps(customerSerEmpIS);
        FileReader normalCustomerIS = new FileReader(normalCustomerFile);
        loadNormalCustomers(normalCustomerIS);
        FileReader companiesIS = new FileReader(companyFile);
        loadCompanies(companiesIS);
    }

    private void loadJackets(FileReader jacketIS) throws IOException {
        bfr = new BufferedReader(jacketIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);

            Size size;
            switch(dividedLine[1]) {
                case "S":
                    size = Size.S;
                    break;
                case "M":
                    size = Size.M;
                    break;
                case "L":
                    size = Size.L;
                    break;
                case "XL":
                    size = Size.XL;
                    break;
                default:
                    throw new RuntimeException("Undefined size value");
            }

            Color color;
            switch(dividedLine[2]) {
                case "red":
                    color = Color.RED;
                    break;
                case "black":
                    color = Color.BLACK;
                    break;
                case "blue":
                    color = Color.BLUE;
                    break;
                case "green":
                    color = Color.GREEN;
                    break;
                case "gray":
                    color = Color.GRAY;
                    break;
                case "pink":
                    color = Color.PINK;
                    break;
                default:
                    throw new RuntimeException("Undefined color value");
            }

            Jacket jacket = new Jacket(Long.parseLong(dividedLine[0]), size, color, Double.parseDouble(dividedLine[3]));
            jacketRepository.save(jacket);
            jackets.add(jacket);
        }
    }

    private void loadManualEmps(FileReader manualEmpIS) throws IOException {
        bfr = new BufferedReader(manualEmpIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);
            ManualEmployee manualEmployee;

            if(dividedLine.length == 7) {
                manualEmployee = new ManualEmployee(dividedLine[0], dividedLine[1], dividedLine[2], Double.parseDouble(dividedLine[3]), LocalDate.parse(dividedLine[4]), Double.parseDouble(dividedLine[5]), Boolean.parseBoolean(dividedLine[6]));
            } else {
                manualEmployee = new ManualEmployee(dividedLine[0], dividedLine[1], dividedLine[2], Double.parseDouble(dividedLine[3]), LocalDate.parse(dividedLine[4]), Boolean.parseBoolean(dividedLine[5]));
            }

            manualEmployees.add(manualEmployee);
            employeeRepository.save(manualEmployee);
        }
    }

    private void loadCustomerSerEmps(FileReader customerSerEmpIS) throws IOException {
        bfr = new BufferedReader(customerSerEmpIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);
            CustomerServiceEmployee customerSerEmployee;

            if(dividedLine.length == 7) {
                customerSerEmployee = new CustomerServiceEmployee(dividedLine[0], dividedLine[1], dividedLine[2], Double.parseDouble(dividedLine[3]), LocalDate.parse(dividedLine[4]), Double.parseDouble(dividedLine[5]), Arrays.asList(dividedLine[6].split(languagesDelimiter)));
            } else {
                customerSerEmployee = new CustomerServiceEmployee(dividedLine[0], dividedLine[1], dividedLine[2], Double.parseDouble(dividedLine[3]), LocalDate.parse(dividedLine[4]), Arrays.asList(dividedLine[5].split(languagesDelimiter)));
            }

            customerServiceEmployees.add(customerSerEmployee);
            employeeRepository.save(customerSerEmployee);
        }
    }

    private void loadNormalCustomers(FileReader normalCustomerIS) throws IOException {
        bfr = new BufferedReader(normalCustomerIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);

            NormalCustomer normalCustomer = new NormalCustomer(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3], dividedLine[4]);
            normalCustomers.add(normalCustomer);
            customerRepository.save(normalCustomer);
        }
    }

    private void loadCompanies(FileReader companiesIS) throws IOException {
        bfr = new BufferedReader(companiesIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);

            Company company = new Company(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3]);
            companies.add(company);
            customerRepository.save(company);
        }
    }
}