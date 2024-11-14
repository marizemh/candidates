CREATE TABLE candidates (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            email VARCHAR(100) NOT NULL,
                            gender VARCHAR(10),
                            salary_expected DECIMAL(10, 2),
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);