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
         
        string firstName,
        string lastName,
        string bornAfter,
        string bornBefore,
        integer page,
        integer pageSize,
    ) {
    }
    @Override
    public createPerson(
         person,
        string type,
    ) {
    }
    @Override
    public searchPersons(
        string search,
        integer page,
        integer pageSize,
    ) {
    }
    @Override
    public advancedSearchPersons(
         searchCriteria,
        integer page,
        integer pageSize,
         
    ) {
    }
    @Override
    public getPersonWithDisabilityBySsin(
         ssin,
    ) {
    }
    @Override
    public getPersonById(
         
         
    ) {
    }
    @Override
    public updatePerson(
         
         person,
    ) {
    }
    @Override
    public updateContactInfo(
         
         contactInfo,
    ) {
    }
    @Override
    public createPersonBelgianAddress(
         
         address,
    ) {
    }
    @Override
    public getBelgianAddressById(
         
         
    ) {
    }
    @Override
    public updateBelgianAddress(
         
         
         address,
    ) {
    }
    @Override
    public createForeignAddress(
         
         address,
    ) {
    }
    @Override
    public getForeignAddressById(
         
         
    ) {
    }
    @Override
    public updateForeignAddress(
         
         
         address,
    ) {
    }
    @Override
    public createRelation(
         
         relation,
    ) {
    }
    @Override
    public getRelationById(
         
         
    ) {
    }
    @Override
    public updateRelation(
         
         
         relation,
    ) {
    }
    @Override
    public getInscriptions(
         
        string context,
        string code,
        boolean active,
    ) {
    }
    @Override
    public createInscription(
         
         inscription,
    ) {
    }
    @Override
    public getInscriptionById(
         
         
    ) {
    }

}