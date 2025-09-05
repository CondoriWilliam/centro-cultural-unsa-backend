CREATE TABLE Authors (
    id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    link_image VARCHAR(255),
    activate BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

CREATE TABLE Exhibitions (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    start_date DATE,
    end_date DATE,
    link_image VARCHAR(255),
    activate BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

CREATE TABLE Rooms (
    id SERIAL PRIMARY KEY NOT NULL,
    exhibition_id INT,
    name VARCHAR(255) NOT NULL,
    pos_top INT,
    pos_bottom INT,
    pos_left INT,
    pos_right INT,
    activate BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50),
    FOREIGN KEY (exhibition_id) REFERENCES Exhibitions(id) ON DELETE CASCADE
);

CREATE TABLE Pictures (
    id SERIAL PRIMARY KEY NOT NULL,
    author_id INT,
    room_id INT,
    name VARCHAR(255) NOT NULL,
    technique VARCHAR(255),
    category VARCHAR(255),
    description TEXT,
    year DATE,
    link_image VARCHAR(255),
    link_qr VARCHAR(255),
    link_audio VARCHAR(255),
    pos_x INT,
    pos_y INT,
    activate BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50),
    FOREIGN KEY (author_id) REFERENCES Authors(id) ON DELETE SET NULL,
    FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE CASCADE
);
