CREATE TABLE employee (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          department VARCHAR(50),
                          salary DOUBLE
);

INSERT INTO employee (name, email, department, salary) VALUES
                                                           ('Arun', 'arun@test.com', 'IT', 50000),
                                                           ('Priya', 'priya@test.com', 'HR', 45000);
