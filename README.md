<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/julian-pena/literalura">
    <img src="https://github.com/julian-pena/literalura/assets/75828460/b563a5b9-4264-4356-acf5-3b652bb85348"
>
  </a>

<h1 align="center">Literalura Library</h1>

  <p align="center">
    <h4>A Java-based application that consumes the Gutendex API to manage and explore book data.</h4>
    <br />
    <a href="https://github.com/julian-pena/literalura"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/julian-pena/literalura">View Demo</a>
    ·
    <a href="https://github.com/julian-pena/literalura/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/julian-pena/literalura/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project

The Literalura Book Data Explorer is a Java application that interacts with the Gutendex API, enabling users to search, list, and manage book data. 

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Java][Java.java]][Java-url]
* [![PostgresSQL][PostgresSQL.sql]][PostgresSQL-url]
* [![SpringBoot][SpringBoot.java]][SpringBoot-url]
* [![Hibernate][Hibernate.java]][Hibernate-url]
* [![Maven][Maven.com]][Maven-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

This guide will help you set up and run the book explorer locally on your machine.

### Prerequisites

**1. Java 17 or higher**
- Before you begin, you should check your current Java installation by using the following command:

For Windows:
   ```bash
   java --version
   ```
For Linux:
   ```bash
  $ java -version
   ```

**2. Maven**

- If you do not already have Maven installed, you can follow the instructions at [maven.apache.org](https://maven.apache.org/download.cgi/).

**3. PostgreSQL**

- If you do not already have PostgreSQL installed, you can follow the instructions at [postgresql.org](https://www.postgresql.org/download/).


### Installation

**1. Clone the repo**
   ```sh
   git clone https://github.com/julian-pena/literalura.git
   ```
**2. Create PostgreSQL Database**

- Open your PostgreSQL client (e.g., pgAdmin or psql).
- Create Database:
 ```bash
   CREATE DATABASE your_database_name;
   ```
- Connect to Database:
 ```bash
   \c your_database_name;
   ```

**3. Configure PostgreSQL connection as per your installation**

- Open `src/main/resources/application.properties`<br><br> 
- Update `{DB_HOST}`,`{DB_NAME}`, `{DB_USER}` and `{DB_PASSWORD}` to your PostgresSQL configuration. <br><br>
- *(Optional)* You can set up these variables as local variables in your local machine


**4. Build and run the project using Maven**
   ```sh
   mvn spring-boot:run
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

The application provides a command-line interface to interact with book data. Here are the main functionalities:

1. ##### Search a book: Enter the title of a book to search for it in the Gutendex API.
2. ##### List searched books: Display a list of books previously searched and stored in the database.
3. ##### List searched authors: Display a list of authors whose books have been searched and stored in the database.
4. ##### List authors alive in a certain period: Enter a year to find authors alive during that time.
5. ##### List books by language: Enter a language code to list books available in that language.

<br>

![literaluramenu](https://github.com/julian-pena/literalura/assets/75828460/1586f7ad-8db4-4a7a-a615-23cc3b25c46e)


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ]  Implement user authentication
- [ ]  Add support for more advanced book search filters
- [ ]  Create a web-based UI for easier interaction

See the [open issues](https://github.com/julian-pena/literalura/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Julian Peña - julianpr8@hotmail.com

Project Link: [https://github.com/julian-pena/literalura](https://github.com/julian-pena/literalura)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Spring Boot Documentation](https://spring.io/projects/spring-boot)
* [PostgresSQL Documentation](https://www.postgresql.org/docs/)
* [Gutendex API](https://gutendex.com/)
* [Java Web: Build applications using Spring Boot (Alura)](https://app.aluracursos.com/degree/certificate/7ee9d6b8-4219-45df-84dd-17ad6fa41a90?lang)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/julian-pena/literalura.svg?style=for-the-badge
[contributors-url]: https://github.com/julian-pena/literalura/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/julian-pena/literalura.svg?style=for-the-badge
[forks-url]: https://github.com/julian-pena/literalura/network/members
[stars-shield]: https://img.shields.io/github/stars/julian-pena/literalura.svg?style=for-the-badge
[stars-url]: https://github.com/julian-pena/literalura/stargazers
[issues-shield]: https://img.shields.io/github/issues/julian-pena/literalura.svg?style=for-the-badge
[issues-url]: https://github.com/julian-pena/literalura/issues
[license-shield]: https://img.shields.io/github/license/julian-pena/literalura.svg?style=for-the-badge
[license-url]: https://github.com/julian-pena/literalura/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/julian-pena-java
[product-screenshot]: images/screenshot.png
[Java.java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/es/
[PostgresSQL.sql]: https://img.shields.io/badge/postgresql-4169e1?style=for-the-badge&logo=postgresql&logoColor=white
[PostgresSQL-url]: https://www.postgresql.org/
[Hibernate.java]: https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white
[Hibernate-url]: https://hibernate.org/
[SpringBoot.java]: https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white
[SpringBoot-url]: https://spring.io/projects/spring-boot
[Maven.com]: https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white
[Maven-url]: https://maven.apache.org/
