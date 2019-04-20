import { AbstractControl, ValidationErrors } from '@angular/forms';

export class ProductFormValidators {
 static noSpace(cntrl: AbstractControl): ValidationErrors | null {
        // if ((cntrl.value as string).indexOf(' ') >= 0) {
        // return null ;

        // }
        if (cntrl.value === 'aelaf') {
            return { noSpace: true};
        } else {
            return{ noSpace: false};
        }
    }
    static limit(limit: number) {
        return (control: AbstractControl): {[key: string]: any} => {
        const val = Number(control.value);
        if (val != NaN && val > limit) {
        return {"limit": {"limit": limit, "actualValue": val}};
        } else {
        return null;
        }
        }
        }
}
