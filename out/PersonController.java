package be.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor

public class PersonController implements PersonApi {



    @Override
    public getAllPersons(
         
        string firstName
        string lastName
        string bornAfter
        string bornBefore
        string page
        string pageSize
    ) {
    }
    @Override
    public createPerson(
        string person
        string type
    ) {
    }
    @Override
    public searchPersons(
        string search
        string page
        string pageSize
    ) {
    }
    @Override
    public advancedSearchPersons(
        string searchCriteria
        string page
        string pageSize
         
    ) {
    }
    @Override
    public getPersonWithDisabilityBySsin(
        string ssin
    ) {
    }
    @Override
    public getPersonById(
         
         
    ) {
    }
    @Override
    public updatePerson(
         
        string person
    ) {
    }
    @Override
    public updateContactInfo(
         
        string contactInfo
    ) {
    }
    @Override
    public createPersonBelgianAddress(
         
        string address
    ) {
    }
    @Override
    public getBelgianAddressById(
         
         
    ) {
    }
    @Override
    public updateBelgianAddress(
         
         
        string address
    ) {
    }
    @Override
    public createForeignAddress(
         
        string address
    ) {
    }
    @Override
    public getForeignAddressById(
         
         
    ) {
    }
    @Override
    public updateForeignAddress(
         
         
        string address
    ) {
    }
    @Override
    public createRelation(
         
        string relation
    ) {
    }
    @Override
    public getRelationById(
         
         
    ) {
    }
    @Override
    public updateRelation(
         
         
        string relation
    ) {
    }
    @Override
    public getInscriptions(
         
        string context
        string code
        string active
    ) {
    }
    @Override
    public createInscription(
         
        string inscription
    ) {
    }
    @Override
    public getInscriptionById(
         
         
    ) {
    }

}