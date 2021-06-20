package com.example.jacketwholesaler.models;

import com.example.jacketwholesaler.models.entities.*;
import com.example.jacketwholesaler.models.enums.Color;
import com.example.jacketwholesaler.models.enums.Size;
import com.example.jacketwholesaler.repositories.*;
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
import java.util.Optional;

@Component
@Transactional
public class DatabaseDataSeeder implements CommandLineRunner {

    //Repositories
    private final JacketRepository jacketRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository  discountRepository;
    private final WarehouseRepository  warehouseRepository;
    private final QuantityJacketRepository quantityJacketRepository;

    //DataFiles
    private final String jacketFile = "src/main/resources/static/dbseeder/jacket.txt";
    private final String manualEmpFile = "src/main/resources/static/dbseeder/manual_employee.txt";
    private final String customerServEmpFile = "src/main/resources/static/dbseeder/customer_service_employee.txt";
    private final String normalCustomerFile = "src/main/resources/static/dbseeder/normal_customer.txt";
    private final String companyFile = "src/main/resources/static/dbseeder/company.txt";
    private final String discountFile = "src/main/resources/static/dbseeder/discount.txt";
    private final String warehouseFile = "src/main/resources/static/dbseeder/warehouse.txt";
    private final String quantityJacketFile = "src/main/resources/static/dbseeder/quantity_jacket.txt";

    //Lists
    private List<Jacket> jackets = new ArrayList<>();
    private List<ManualEmployee> manualEmployees = new ArrayList<>();
    private List<CustomerServiceEmployee> customerServiceEmployees = new ArrayList<>();
    private List<NormalCustomer> normalCustomers = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();
    private List<Discount> discounts = new ArrayList<>();
    private List<Warehouse> warehouses = new ArrayList<>();
    private List<QuantityJacket> quantityJackets = new ArrayList<>();

    //Others
    private final String delimiter = ";";
    private final String languagesDelimiter = ",";
    private BufferedReader bfr;
    private String line;
    private String[] dividedLine;

    @Autowired
    public DatabaseDataSeeder(JacketRepository jacketRepository, EmployeeRepository employeeRepository, CustomerRepository customerRepository, DiscountRepository discountRepository, WarehouseRepository warehouseRepository, QuantityJacketRepository quantityJacketRepository) {
        this.jacketRepository = jacketRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.warehouseRepository = warehouseRepository;
        this.quantityJacketRepository = quantityJacketRepository;
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
        FileReader discountIS = new FileReader(discountFile);
        loadDiscounts(discountIS);
        FileReader warehouseIS = new FileReader(warehouseFile);
        loadWarehouses(warehouseIS);
        FileReader quantityJacketIS = new FileReader(quantityJacketFile);
        loadQuantityJackets(quantityJacketIS);
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

    private void loadDiscounts(FileReader discountIS) throws IOException {
        bfr = new BufferedReader(discountIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);

            Discount discount = new Discount(Integer.parseInt(dividedLine[0]), Integer.parseInt(dividedLine[1]));
            discounts.add(discount);
            discountRepository.save(discount);
        }
    }

    private void loadWarehouses(FileReader warehouseIS) throws IOException {
        bfr = new BufferedReader(warehouseIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);
            Warehouse warehouse;

            if(dividedLine.length == 4) {
                warehouse = new Warehouse(dividedLine[0], Integer.parseInt(dividedLine[1]), Integer.parseInt(dividedLine[2]), dividedLine[3]);
            } else {
                warehouse = new Warehouse(dividedLine[0], Integer.parseInt(dividedLine[1]), dividedLine[2]);
            }

            warehouses.add(warehouse);
            warehouseRepository.save(warehouse);
        }
    }

    private void loadQuantityJackets(FileReader quantityJacketIS) throws IOException {
        bfr = new BufferedReader(quantityJacketIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);
            QuantityJacket quantityJacket = new QuantityJacket(Integer.parseInt(dividedLine[0]));
            Optional<Jacket> jacket = jacketRepository.findById(Long.parseLong(dividedLine[1]));

            if(jacket.isEmpty()) {
                throw new RuntimeException("Error in input data");
            }
            quantityJacket.setJacket(jacket.get());

            quantityJackets.add(quantityJacket);
            quantityJacketRepository.save(quantityJacket);
        }
    }
}
