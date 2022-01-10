package hes.wallis.mark;

import android.util.Log;

public class CalculateAverageMarks {

    //Language
    public static Double German(){
        Double markGermanS1Exam1 = Marks.getFromMemorize("S1GermanExam_1");
        Double markGermanS1Semester = Marks.getFromMemorize("S1GermanSemester");
        Double average;
        if(markGermanS1Exam1*markGermanS1Semester == 0.0){
            average = markGermanS1Exam1 + markGermanS1Semester;
        } else {
            average = (markGermanS1Exam1 + markGermanS1Semester)/2.0;
        }
        // arrondi dans Resume fragment
        return average;
    }

    //Science
    public static Double Mathematics(){
        Double markMathematicsS1Exam1 = Marks.getFromMemorize("S1MathematicsExam_1");
        Double markMathematicsS1Exam2 = Marks.getFromMemorize("S1MathematicsExam_2");
        Double markMathematicsS1semester = Marks.getFromMemorize("S1MathematicsSemester");
        Double average = 0.0;
        return average;
    }
    public static Double Informatic(){
        Double markInformaticS1Exam1 = Marks.getFromMemorize("S1InformaticExam_1");
        Double markInformaticS1Bonus = Marks.getFromMemorize("S1InformaticBonus");
        Double markInformaticS1semester = Marks.getFromMemorize("S1InformaticSemester");
        Double average = 0.0;
        return average;
    }
    public static Double Physic(){
        Double average = 0.0;
        return average;
    }
    public static Double Science(){
        Double average = 0.0;
        return average;
    }

    //Business
    public static Double TeM(){
        Double markTeMS1Rapport1 = Marks.getFromMemorize("S1TeMRapport_1");
        Double markTeMS1Rapport2 = Marks.getFromMemorize("S1TeMRapport_2");
        Double markTeMS1Rapport3 = Marks.getFromMemorize("S1TeMRapport_3");
        Double markTeMS1Exam1 = Marks.getFromMemorize("S1TeMExam_1");
        Double markTeMS1Semester = Marks.getFromMemorize("S1TeMSemester");

        Double averageRapport;
        if(markTeMS1Rapport1*markTeMS1Rapport2 == 0.0){
            averageRapport = markTeMS1Rapport1 + markTeMS1Rapport2;
        } else {
            averageRapport = (markTeMS1Rapport1 + markTeMS1Rapport2)/2.0;
        }
        averageRapport = Marks.aroundDixie(averageRapport);


        Double average;
        if(markTeMS1Semester == 0.0){
            average = (averageRapport + markTeMS1Exam1)/2.0;
        } else if( (averageRapport != 0.0) && (markTeMS1Exam1 != 0.0) && (markTeMS1Semester != 0.0) ){
            average = (averageRapport + markTeMS1Exam1)/2.0;
            average = (average + markTeMS1Semester)/2.0;
        } else if(averageRapport*markTeMS1Exam1*markTeMS1Semester == 0.0) {
            average = averageRapport + markTeMS1Exam1 + markTeMS1Semester;
        } else {
            average = 0.0;
        }
        average = Marks.aroundDixie(average);

        return average;
    }
    public static Double CCo(){
        Double markCCoS1Exam1 = Marks.getFromMemorize("S1CCoExam_1");
        Double markCCoS1Projet = Marks.getFromMemorize("S1CCoProjet");
        Double markCCoS1Semester = Marks.getFromMemorize("S1CCoSemester");

        Double averageS1;
        if(markCCoS1Exam1*markCCoS1Projet == 0.0){
            averageS1 = markCCoS1Exam1 + markCCoS1Projet;
        } else {
            averageS1 = (markCCoS1Exam1 + markCCoS1Projet)/2.0;
        }
        averageS1 = Marks.aroundDixie(averageS1);


        Double average;
        if(averageS1*markCCoS1Semester == 0.0){
            average = averageS1 + markCCoS1Semester;
        } else {
            average = (averageS1 + markCCoS1Semester)/2.0;
        }
        average = Marks.aroundDixie(average);

        return average;
    }
    public static Double Mechanic(){
        Double markTeMS1Rapport1 = Marks.getFromMemorize("S1TeMRapport_1");
        Double markTeMS1Rapport2 = Marks.getFromMemorize("S1TeMRapport_2");
        Double markTeMS1Rapport3 = Marks.getFromMemorize("S1TeMRapport_3");
        Double markTeMS1Exam1 = Marks.getFromMemorize("S1TeMExam_1");
        Double markTeMS1Semester = Marks.getFromMemorize("S1TeMSemester");
        Double markCCoS1Exam1 = Marks.getFromMemorize("S1CCoExam_1");
        Double markCCoS1Projet = Marks.getFromMemorize("S1CCoProjet");
        Double markCCoS1Semester = Marks.getFromMemorize("S1CCoSemester");

        //Rapport TeM
        Double averageRapport;
        if(markTeMS1Rapport1*markTeMS1Rapport2 == 0.0){
            averageRapport = markTeMS1Rapport1 + markTeMS1Rapport2;
        } else {
            averageRapport = (markTeMS1Rapport1 + markTeMS1Rapport2)/2.0;
        }
        averageRapport = Marks.aroundDixie(averageRapport);

        //Note semestre
        Double averageSemester1 = 0.0;

        boolean S1TeMEx1 = false;
        if (markTeMS1Exam1 != 0.0) S1TeMEx1 = true;
        boolean S1rapportsTeM = false;
        if (averageRapport != 0.0) S1rapportsTeM = true;
        boolean S1projet = false;
        if (markCCoS1Projet != 0.0) S1projet = true;
        boolean S1CCoEx1 = false;
        if (markCCoS1Exam1 != 0.0) S1CCoEx1 = true;

        if(S1TeMEx1 && S1rapportsTeM && S1CCoEx1 && S1projet){
            averageSemester1 += 3 * markTeMS1Exam1;
            averageSemester1 += 3 * averageRapport;
            averageSemester1 += 2 * markCCoS1Exam1;
            averageSemester1 += 2 * markCCoS1Projet;
            averageSemester1 /= 10.0;
        } else if(S1TeMEx1 && S1rapportsTeM && S1CCoEx1) {
            averageSemester1 += 3 * markTeMS1Exam1;
            averageSemester1 += 3 * averageRapport;
            averageSemester1 += 2 * markCCoS1Exam1;
            averageSemester1 /= 8.0;
        } else {
            averageSemester1 = 0.0;
        }
        averageSemester1 = Marks.aroundDixie(averageSemester1);

        Double averageExamSemester1;
        if(markTeMS1Semester*markCCoS1Semester == 0.0){
            averageExamSemester1 = markTeMS1Semester + markCCoS1Semester;
        } else {
            averageExamSemester1 = (markTeMS1Semester + markCCoS1Semester)/2.0;
        }
        averageExamSemester1 = Marks.aroundDixie(averageExamSemester1);


        Double average;
        if(averageExamSemester1 != 0.0){
            average = (averageSemester1+averageExamSemester1)/2.0;
        } else {
            average = averageSemester1;
        }
        average = Marks.aroundDixie(average);
        return average;
    }
    public static Double EIN(){
        Double markEINS1Exam1 = Marks.getFromMemorize("S1EINExam_1");
        Double markEINS1Exam2 = Marks.getFromMemorize("S1EINExam_2");
        Double markEINS1Project = Marks.getFromMemorize("S1EINProject");
        Double markEINS1semester = Marks.getFromMemorize("S1EINSemester");

        Double averageSemester1 = 0.0;
        if(markEINS1Exam1 != 0.0 && markEINS1Exam2 != 0.0 && markEINS1Project != 0.0){
            averageSemester1 += 3.0 * markEINS1Exam1;
            averageSemester1 += 3.0 * markEINS1Exam2;
            averageSemester1 += 4.0 * markEINS1Project;
            averageSemester1 /= 10.0;
        } else if (markEINS1Exam1 != 0.0 && markEINS1Exam2 != 0.0){
            averageSemester1 += 3.0 * markEINS1Exam1;
            averageSemester1 += 3.0 * markEINS1Exam2;
            averageSemester1 /= 6.0;
        } else if (markEINS1Exam1 != 0.0){
            averageSemester1 += markEINS1Exam1;
        } else {
            averageSemester1 = 0.0;
        }
        averageSemester1 = Marks.aroundDixie(averageSemester1);

        Double average;
        if(averageSemester1 != 0 && markEINS1semester != 0){
            average = (averageSemester1+markEINS1semester)/2.0;
        } else {
            average = averageSemester1+markEINS1semester;
        }
        average = Marks.aroundDixie(average);
        return average;
    }
    public static Double EIA(){
        Double average = 0.0;
        return average;
    }
    public static Double Electricity(){
        Double average;
        Double ein = Marks.aroundDixie(EIN());
        Double eia = Marks.aroundDixie(EIA());
        if (eia != 0.0){
            average = (ein+eia)/2.0;
        } else {
            average = ein;
        }
        average = Marks.aroundDixie(average);
        return average;
    }
    public static Double Business(){
        Double average;
        Double mechanic = Mechanic();
        Double electricity = Electricity();
        if(mechanic != 0.0 && electricity != 0.0){
            average = (mechanic+electricity)/2;
        } else {
            average = mechanic+electricity;
        }
        average = Marks.aroundDemi(average);
        return average;
    }
}
