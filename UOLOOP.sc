Program TrainingSkills;
Const
Target1 = $00000000; //
Target2 = $00000000; //
Type1 = $0190; // Banker
Type2 = $13B1; // Bow
Type3 = $00DC; // Llama
Type4 = $0994; // Pear

Procedure UseSkillUntil(SkillName: String; SkillValue: Double; WaitTime: Cardinal; FirstTargetID: Cardinal; UseFirstTarget: Boolean; SecondTargetID: Cardinal; UseSecondTarget: Boolean);
begin
    while GetSkillValue(Skillname) < SkillValue do
    begin
        if Warmode then SetWarMode(false);
        while Dead do Wait(10000);
        while not Connected() do
        begin
            Connect();
            Wait(10000);
        end;
        UseSkill(Skillname);
        if UseFirstTarget = True then
        begin
            WaitForTarget(1000);
            if TargetPresent then TargetToObject(FirstTargetID); 
        end;
        if UseSecondTarget = True then
        begin
            WaitForTarget(1000);
            if TargetPresent then TargetToObject(SecondTargetID); 
        end;
        Wait(WaitTime);
    end;
end;

begin
    FindDistance:= 10;   
    UseSkillUntil('Evaluate Intelligence',100.0,3000,FindType(Type1,Ground),True,Target2,False);
    UseSkillUntil('Anatomy',100.0,4000,FindType(Type1,Ground),True,Target2,False);
    UseSkillUntil('Arms Lore',100.0,1000,FindType(Type2,Backpack),True,Target2,False); 
    UseSkillUntil('Item ID',100.0,4000,FindType(Type2,Backpack),True,Target2,False);  
    UseSkillUntil('Taste Identification',100.1,2500,FindType(Type2,Backpack),True,Target2,False);     
    UseSkillUntil('Hiding', 100.0, 4000, Target1, False, Target2,False);
    UseSkillUntil('Stealth', 100.0, 4000, Target1, False, Target2,False); 
    UseSkillUntil('Animal Lore',100.0,4000,FindType(Type3,Ground),True,Target2,False); 
    UseSkillUntil('Enticement',100.0,3500,FindType(Type3,Ground),True,Target2,False);  
    UseSkillUntil('Spirit Speak',100.0,7000,FindType(Type1,Ground),False,Target2,False);   
    
end.   